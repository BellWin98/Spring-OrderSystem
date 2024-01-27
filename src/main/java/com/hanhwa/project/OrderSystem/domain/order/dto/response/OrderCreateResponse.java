package com.hanhwa.project.OrderSystem.domain.order.dto.response;

import com.hanhwa.project.OrderSystem.domain.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class OrderCreateResponse {
    private Long orderId;
    private String orderName;
    private String memberNickname;

    public static OrderCreateResponse from(Order order){
        return new OrderCreateResponse(
                order.getId(),
                order.getName(),
                order.getMember().getNickname()
        );
    }
}
