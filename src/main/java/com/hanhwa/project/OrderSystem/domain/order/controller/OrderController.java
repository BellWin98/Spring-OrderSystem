package com.hanhwa.project.OrderSystem.domain.order.controller;

import com.hanhwa.project.OrderSystem.domain.order.dto.request.OrderCreateRequest;
import com.hanhwa.project.OrderSystem.domain.order.dto.response.OrderCreateResponse;
import com.hanhwa.project.OrderSystem.domain.order.dto.response.OrderItemResponse;
import com.hanhwa.project.OrderSystem.domain.order.exception.OrderAlreadyCanceledException;
import com.hanhwa.project.OrderSystem.domain.order.service.OrderService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    // 주문 생성
    @PostMapping("/order/new")
    public ResponseEntity<OrderCreateResponse> createOrder(@RequestBody OrderCreateRequest req){
        return new ResponseEntity<>(orderService.createOrder(req), HttpStatus.CREATED);
    }

    // orderItems 목록 조회
    @GetMapping("/orderitems/{id}")
    public ResponseEntity<List<OrderItemResponse>> getOrderItems(@PathVariable Long id){
        return new ResponseEntity<>(orderService.getOrderItems(id), HttpStatus.OK);
    }

    // 주문 취소
    @DeleteMapping("/order/{id}/cancel")
    public ResponseEntity<String> cancelOrder(@PathVariable Long id){
        try{
            orderService.cancelOrder(id);
            return new ResponseEntity<>("주문 번호 " + id + "번의 주문이 취소되었습니다.", HttpStatus.OK);
        } catch (OrderAlreadyCanceledException e){
            return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
        }
    }
}
