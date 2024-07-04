package br.com.daniel.springbootcalculator.exceptions;

public class DivisionByZeroException extends RuntimeException {
    private final int errorCode;

    public DivisionByZeroException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}