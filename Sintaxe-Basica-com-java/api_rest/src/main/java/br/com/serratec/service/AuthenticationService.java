package br.com.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.serratec.dto.LoginDTO;
import br.com.serratec.dto.Token;
import br.com.serratec.dto.UsuarioDTO;
import br.com.serratec.dto.UsuarioQueSeraAvaliadoResponseDTO;
import br.com.serratec.entity.DataEntity;
import br.com.serratec.entity.LoginEntity;
import br.com.serratec.entity.UsuarioEntity;
import br.com.serratec.exception.EmaileSenhaException;
import br.com.serratec.exception.SemEmailException;
import br.com.serratec.exception.SemSenhaException;
import br.com.serratec.repository.DataRepository;
import jakarta.validation.Valid;

@Service
public class AuthenticationService {

    @Autowired
    private LoginService loginService;

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private UsuarioService usuarioService;

    // Get para logar no sistema!
    public String loginPost(LoginDTO login) {
        // TODO: Jeito mais elegante de fazer isso aqui com certeza existe!
        if (login.password() == null && login.email() == null)
            throw new EmaileSenhaException();
        if (login.password() == null)
            throw new SemSenhaException();
        if (login.email() == null)
            throw new SemEmailException();

        List<UsuarioQueSeraAvaliadoResponseDTO> verificacaoDeBanco = usuarioService.pegarTodosColaboradores();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Token> response = restTemplate.postForEntity(
                "http://t2m-iqs.southcentralus.cloudapp.azure.com:9091/api/login",
                login,
                Token.class);

        Token tokenDTO = response.getBody();

        if (tokenDTO != null) {
            LoginEntity loginEntity = new LoginEntity(tokenDTO.token(), tokenDTO.refreshToken());
            loginService.saveLoginEntity(loginEntity);

            if (verificacaoDeBanco.size() <= 0) {
                consultaUsuario(loginEntity.getToken());
            }

            return loginEntity.getToken();
        } else {
            return null;
            
        }
    }

    // Get Todos os usuários
    public DataEntity consultaUsuario(@Valid String loginUsuario) {
        RestTemplate restTemplate = new RestTemplate();

        /*
         * if (login == null) {
         * throw new LoginException();
         * }
         */

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(loginUsuario);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<DataEntity> resp = restTemplate.exchange(
                "http://t2m-iqs.southcentralus.cloudapp.azure.com:9091/api/User",
                HttpMethod.GET,
                entity,
                DataEntity.class);

        DataEntity dataEntity = new DataEntity();
        dataEntity = resp.getBody();
        return loginService.saveDataEntity(dataEntity);
    }

    public UsuarioDTO consultaRole(String personalEmail) {
        UsuarioEntity entity = loginService.listarEmail(personalEmail);

        UsuarioDTO dto = new UsuarioDTO();

        dto.setFullName(entity.getFullName());
        dto.setPersonalEmail(entity.getPersonalEmail());
        dto.setCorporativeEmail(entity.getCorporativeEmail());
        dto.setRole(entity.getRole());
        dto.setAdmissionDate(entity.getAdmissionDate());

        return dto;
    }

    public List<DataEntity> listarTodos() {
        return dataRepository.findAll();
    }

}
