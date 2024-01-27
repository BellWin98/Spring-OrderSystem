package com.hanhwa.project.OrderSystem.domain.member.exception;

import static com.hanhwa.project.OrderSystem.domain.member.exception.contants.MemberExceptionList.EMAIL_ALREADY_EXIST;

public class EmailAlreadyExistException extends MemberException{

    public EmailAlreadyExistException() {
        super(EMAIL_ALREADY_EXIST.getHttpStatus(),
                EMAIL_ALREADY_EXIST.getMessage());
    }
}
