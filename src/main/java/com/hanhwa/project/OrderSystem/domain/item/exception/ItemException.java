package com.hanhwa.project.OrderSystem.domain.item.exception;

import com.hanhwa.project.OrderSystem.global.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class ItemException extends ApplicationException {
    protected ItemException(HttpStatus httpStatus, String message) {
        super(httpStatus, message);
    }
}
