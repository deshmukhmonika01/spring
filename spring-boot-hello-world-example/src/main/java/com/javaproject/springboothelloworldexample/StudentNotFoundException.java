package com.javaproject.springboothelloworldexample;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String exception) {
        super(exception);
    }
}
