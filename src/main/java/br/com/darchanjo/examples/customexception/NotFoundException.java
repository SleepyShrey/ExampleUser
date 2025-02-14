package br.com.darchanjo.examples.customexception;

public class NotFoundException extends RuntimeException {

    // Constructor without any message
    public NotFoundException() {
        super();
    }

    // Constructor with a message
    public NotFoundException(String message) {
        super(message);
    }
}
