package com.hanhwa.project.OrderSystem.domain.order.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class OrderCreateRequest {
    private Long memberId;
    private List<OrderItemCreateRequest> orderItems;

    @Data
    public static class OrderItemCreateRequest {
        private Long itemId;
        private int quantity;
    }
}
