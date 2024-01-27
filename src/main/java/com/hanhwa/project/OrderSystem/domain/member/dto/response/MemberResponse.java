package com.hanhwa.project.OrderSystem.domain.member.dto.response;

import com.hanhwa.project.OrderSystem.domain.member.entity.Member;
import com.hanhwa.project.OrderSystem.domain.member.entity.Role;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberResponse {
    private String email;
    private String nickname;
    private String address;
    private Role role;

    public static MemberResponse from(Member member){
        return MemberResponse.builder()
                .email(member.getEmail())
                .nickname(member.getNickname())
                .address(member.getAddress())
                .role(member.getRole())
                .build();
    }
}
