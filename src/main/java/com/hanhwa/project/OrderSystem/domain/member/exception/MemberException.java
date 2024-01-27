package com.hanhwa.project.OrderSystem.domain.member.exception;

import com.hanhwa.project.OrderSystem.global.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class MemberException extends ApplicationException {
    protected MemberException(HttpStatus httpStatus, String message) {
        super(httpStatus, message);
    }
}
