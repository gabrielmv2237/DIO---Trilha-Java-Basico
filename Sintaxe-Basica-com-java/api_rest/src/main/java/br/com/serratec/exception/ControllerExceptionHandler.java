package br.com.serratec.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> erros = new ArrayList<>();
        for (FieldError f : ex.getBindingResult().getFieldErrors()) {
            erros.add(f.getField() + ":" + f.getDefaultMessage());
        }

        RespostaAosErros er = new RespostaAosErros(status.value(), "Erro de requisição, verificar o Json:",
                LocalDateTime.now(),
                erros);
        return super.handleExceptionInternal(ex, er, headers, status, request);
    }

    // List
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        RespostaAosErros er = new RespostaAosErros(status.value(),
                "Erro na hora da requisição Verifique o JSON ou contate o pessoal do Back-end", // Mensagem mockada
                LocalDateTime.now(), null);
        return super.handleExceptionInternal(ex, er, headers, status, request);
    }

    // Tratamento específico do Token!!!!
    @ExceptionHandler(LoginException.class)
    protected ResponseEntity<Object> handleLoginException(LoginException ex, WebRequest request) {
        List<String> erros = new ArrayList<>();
        erros.add(ex.getMessage());

        RespostaAosErros er = new RespostaAosErros(HttpStatus.NOT_ACCEPTABLE.value(), "Login inválido",
                LocalDateTime.now(), erros);

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(er);
    }

    @ExceptionHandler(SemSenhaException.class)
    protected ResponseEntity<Object> handleSemSenhaException(SemSenhaException ex) {
        List<String> erros = new ArrayList<>();
        erros.add(ex.getMessage());

        RespostaAosErros RespostaAosErros = new RespostaAosErros(HttpStatus.NOT_FOUND.value(),
                "Por favor insira uma senha",
                LocalDateTime.now(), erros);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(RespostaAosErros);
    }

    @ExceptionHandler(SemEmailException.class)
    protected ResponseEntity<Object> handleSemEmailException(SemEmailException ex) {
        List<String> erros = new ArrayList<>();
        erros.add(ex.getMessage());

        RespostaAosErros RespostaAosErros = new RespostaAosErros(HttpStatus.NOT_FOUND.value(),
                "Por favor insira uma email",
                LocalDateTime.now(), erros);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(RespostaAosErros);
    }

    @ExceptionHandler(EmaileSenhaException.class)
    protected ResponseEntity<Object> handleEmaileSenhaException(EmaileSenhaException ex) {
        List<String> erros = new ArrayList<>();
        erros.add(ex.getMessage());

        RespostaAosErros RespostaAosErros = new RespostaAosErros(HttpStatus.NOT_FOUND.value(),
                "Por favor insira uma email e senha",
                LocalDateTime.now(), erros);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(RespostaAosErros);
    }

    @ExceptionHandler(AvaliacaoException.class)
    protected ResponseEntity<Object> handleAvaliacaoException(AvaliacaoException ex){
        List<String> erros = ex.getMessages();

        RespostaAosErros respostaAosErros = new RespostaAosErros(HttpStatus.NOT_FOUND.value(), 
        "Existem erros na hora de Fazer a avaliação.",
        LocalDateTime.now(), erros);
                                                                //Esse aqui é diferente e puxa a lista dos erros!
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respostaAosErros);
        
    }
}
