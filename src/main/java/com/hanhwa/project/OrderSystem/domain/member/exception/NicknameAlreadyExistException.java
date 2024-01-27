package com.hanhwa.project.OrderSystem.domain.member.exception;

import static com.hanhwa.project.OrderSystem.domain.member.exception.contants.MemberExceptionList.NICKNAME_ALREADY_EXIST;

public class NicknameAlreadyExistException extends MemberException{

    public NicknameAlreadyExistException(){
        super(NICKNAME_ALREADY_EXIST.getHttpStatus(),
                NICKNAME_ALREADY_EXIST.getMessage());
    }
}
