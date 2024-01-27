package com.hanhwa.project.OrderSystem.domain.order.dto.response;

import com.hanhwa.project.OrderSystem.domain.order.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderItemResponse {
    private String name;
    private int quantity;

    public static OrderItemResponse from(OrderItem orderItem){
        return new OrderItemResponse(orderItem.getItem().getName(),
                orderItem.getQuantity());
    }
}
