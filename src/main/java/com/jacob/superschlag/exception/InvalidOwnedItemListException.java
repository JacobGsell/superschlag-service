package com.jacob.superschlag.exception;

public class InvalidOwnedItemListException extends RuntimeException{
    public InvalidOwnedItemListException() {
        super();
    }

    public InvalidOwnedItemListException(String message) {
        super(message);
    }
}
