package br.com.serratec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.entity.DataEntity;
import br.com.serratec.entity.LoginEntity;
import br.com.serratec.entity.UsuarioEntity;
import br.com.serratec.repository.DataRepository;
import br.com.serratec.repository.LoginRepository;
import br.com.serratec.repository.UsuarioRepository;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;
    
    @Autowired
    private DataRepository dataRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public LoginEntity getLoginEntity() {
        return loginRepository.findById(1L).orElse(null);
    }

    public void saveLoginEntity(LoginEntity loginEntity) {
        loginRepository.save(loginEntity);
    }
    
    public DataEntity saveDataEntity(DataEntity dataEntity) {
    	return dataRepository.save(dataEntity);
    }
    
    public UsuarioEntity listarEmail(String personalEmail) {
		UsuarioEntity usuario = usuarioRepository.findByCorporativeEmail(personalEmail);
		return usuario;
	}
    
    
}
	