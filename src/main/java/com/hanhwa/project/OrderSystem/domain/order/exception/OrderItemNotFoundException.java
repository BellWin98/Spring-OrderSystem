package com.hanhwa.project.OrderSystem.domain.order.exception;

import static com.hanhwa.project.OrderSystem.domain.member.exception.contants.MemberExceptionList.EMAIL_ALREADY_EXIST;
import static com.hanhwa.project.OrderSystem.domain.order.exception.constants.OrderExceptionList.ORDER_ITEM_NOT_FOUND;

public class OrderItemNotFoundException extends OrderException{
    public OrderItemNotFoundException() {
        super(ORDER_ITEM_NOT_FOUND.getHttpStatus(),
                ORDER_ITEM_NOT_FOUND.getMessage());
    }
}
