package com.hanhwa.project.OrderSystem.domain.member.service;

import com.hanhwa.project.OrderSystem.domain.member.dto.request.MemberCreateRequest;
import com.hanhwa.project.OrderSystem.domain.member.dto.response.MemberCreateResponse;
import com.hanhwa.project.OrderSystem.domain.member.dto.response.MemberResponse;
import com.hanhwa.project.OrderSystem.domain.member.entity.Member;
import com.hanhwa.project.OrderSystem.domain.member.exception.EmailAlreadyExistException;
import com.hanhwa.project.OrderSystem.domain.member.exception.MemberNotFoundException;
import com.hanhwa.project.OrderSystem.domain.member.repository.MemberRepository;
import com.hanhwa.project.OrderSystem.domain.order.dto.response.OrderItemResponse;
import com.hanhwa.project.OrderSystem.domain.order.entity.Order;
import com.hanhwa.project.OrderSystem.domain.order.entity.OrderItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public MemberCreateResponse createMember(MemberCreateRequest req) throws EmailAlreadyExistException{
        log.info("createMember Service start");
        // 이메일 중복 여부 검증
        if (memberRepository.findByEmail(req.getEmail()).isPresent()){
            throw new EmailAlreadyExistException();
        }
        Member member = req.toEntity();
        return MemberCreateResponse.from(memberRepository.save(member));
    }

    public List<MemberResponse> getMembers(){
        log.info("getMembers Service start");
        List<Member> members = memberRepository.findAll();
        List<MemberResponse> memberResponses = new ArrayList<>();
        for (Member member : members){
            memberResponses.add(MemberResponse.from(member));
        }
        log.info("getMembers Service end");
        return memberResponses;
    }

    public List<OrderItemResponse> getMemberOrders(Long id){
        Member findMember = memberRepository.findById(id)
                .orElseThrow(MemberNotFoundException::new);
        List<Order> memberOrders = memberRepository.findMemberOrders(findMember.getId());
        List<OrderItemResponse> orderItemResponses = new ArrayList<>();
        for (Order order : memberOrders){
            for (OrderItem orderItem : order.getOrderItems()){
                orderItemResponses.add(OrderItemResponse.from(orderItem));
            }
        }
        return orderItemResponses;
    }
}
