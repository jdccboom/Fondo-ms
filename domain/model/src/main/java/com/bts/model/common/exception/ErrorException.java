package com.bts.model.common.exception;

import lombok.Getter;

@Getter
public class ErrorException extends Exception {

    private final codeError code;

    public ErrorException(String message, codeError code) {
        super(message);
        this.code = code;
    }
}
