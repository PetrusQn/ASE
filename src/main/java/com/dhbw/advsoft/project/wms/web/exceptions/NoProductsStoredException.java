package com.dhbw.advsoft.project.wms.web.exceptions;

public class NoProductsStoredException extends RuntimeException {
    public NoProductsStoredException(String message) {
        super(message);
    }
}
