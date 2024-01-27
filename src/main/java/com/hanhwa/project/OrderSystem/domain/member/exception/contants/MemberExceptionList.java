package com.hanhwa.project.OrderSystem.domain.member.exception.contants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MemberExceptionList {
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "해당 ID의 회원을 찾을 수 없습니다."),
    NICKNAME_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "이미 존재하는 닉네임입니다."),
    EMAIL_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "이미 존재하는 이메일입니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
