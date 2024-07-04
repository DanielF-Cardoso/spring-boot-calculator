package br.com.daniel.springbootcalculator.exceptions;

public class InvalidNumberException extends RuntimeException {
    private final int errorCode;

    public InvalidNumberException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}