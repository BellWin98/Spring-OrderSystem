package com.hanhwa.project.OrderSystem.domain.member.controller;

import com.hanhwa.project.OrderSystem.domain.member.dto.request.MemberCreateRequest;
import com.hanhwa.project.OrderSystem.domain.member.dto.response.MemberCreateResponse;
import com.hanhwa.project.OrderSystem.domain.member.dto.response.MemberResponse;
import com.hanhwa.project.OrderSystem.domain.member.service.MemberService;
import com.hanhwa.project.OrderSystem.domain.order.dto.response.OrderItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping("/member/new")
    public ResponseEntity<MemberCreateResponse> createMember(@RequestBody MemberCreateRequest req){
        return new ResponseEntity<>(memberService.createMember(req), HttpStatus.CREATED);
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberResponse>> getMembers(){
        return new ResponseEntity<>(memberService.getMembers(), HttpStatus.OK);
    }

    @GetMapping("/member/{id}/orders")
    public ResponseEntity<List<OrderItemResponse>> getMemberOrders(@PathVariable Long id){
        return new ResponseEntity<>(memberService.getMemberOrders(id), HttpStatus.OK);
    }
}
