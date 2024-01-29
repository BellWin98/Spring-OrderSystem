package com.hanhwa.project.OrderSystem.domain.member.entity;

import com.hanhwa.project.OrderSystem.domain.order.entity.Order;
import com.hanhwa.project.OrderSystem.domain.order.entity.OrderItem;
import com.hanhwa.project.OrderSystem.global.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "members")
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false, unique = true, length = 15)
    private String nickname;

    @Column(nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Order> orders;

    @Builder
    public Member(
            String email,
            String password,
            String nickname,
            String address,
            Role role){
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.address = address;
        this.role = role;
    }

    public void updateMemberInfo(String password, String nickname, String address){
        this.password = password;
        this.nickname = nickname;
        this.address = address;
    }

    public void setOrders(List<Order> orders){
        this.orders = orders;
    }
}
