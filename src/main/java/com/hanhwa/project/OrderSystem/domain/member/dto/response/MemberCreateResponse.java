package com.hanhwa.project.OrderSystem.domain.member.dto.response;

import com.hanhwa.project.OrderSystem.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter // 추가
@AllArgsConstructor
public class MemberCreateResponse {
    private String email;
    private String nickname;

    public static MemberCreateResponse from(Member member){
        return new MemberCreateResponse(member.getEmail(), member.getNickname());
    }
}
