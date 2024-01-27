package com.hanhwa.project.OrderSystem.domain.order.exception;

import com.hanhwa.project.OrderSystem.global.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class OrderException extends ApplicationException {
    protected OrderException(HttpStatus httpStatus, String message) {
        super(httpStatus, message);
    }
}
