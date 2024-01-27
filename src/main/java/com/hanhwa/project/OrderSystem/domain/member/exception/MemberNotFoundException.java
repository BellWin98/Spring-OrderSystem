package com.hanhwa.project.OrderSystem.domain.member.exception;

import static com.hanhwa.project.OrderSystem.domain.member.exception.contants.MemberExceptionList.MEMBER_NOT_FOUND;

public class MemberNotFoundException extends MemberException{

    public MemberNotFoundException(){
        super(MEMBER_NOT_FOUND.getHttpStatus(),
                MEMBER_NOT_FOUND.getMessage());
    }
}
