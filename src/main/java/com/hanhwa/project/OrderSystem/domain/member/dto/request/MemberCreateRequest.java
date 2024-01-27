package com.hanhwa.project.OrderSystem.domain.member.dto.request;

import com.hanhwa.project.OrderSystem.domain.member.entity.Member;
import com.hanhwa.project.OrderSystem.domain.member.entity.Role;
import lombok.Data;

@Data
public class MemberCreateRequest {
    private String email;
    private String password;
    private String nickname;
    private String address;
    public Member toEntity(){
        return Member.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .address(address)
                .role(Role.ROLE_USER)
                .build();
    }
}
