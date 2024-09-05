package br.com.serratec.exception;

import java.util.List;

public class AvaliacaoException extends RuntimeException { 

    private static final long serialVersionUID = 1L;
    private List<String> messages;

    public AvaliacaoException(List<String> messages) {
        super(String.join(", ", messages)); 
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }

    @Override
    public String getMessage() {
        return String.join(", ", messages); 
    }
}
