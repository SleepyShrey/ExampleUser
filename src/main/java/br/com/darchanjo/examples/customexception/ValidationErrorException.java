package br.com.darchanjo.examples.customexception;

public class ValidationErrorException extends RuntimeException{

    public ValidationErrorException(String string)
    {
        super(string);
    }
    public ValidationErrorException()
    {
        super();
    }
}
