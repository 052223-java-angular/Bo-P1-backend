package com.revature.flashpoints.utils.custom_exceptions;

    public class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

