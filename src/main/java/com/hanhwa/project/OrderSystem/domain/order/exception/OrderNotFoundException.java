package com.hanhwa.project.OrderSystem.domain.order.exception;

import static com.hanhwa.project.OrderSystem.domain.order.exception.constants.OrderExceptionList.ORDER_ITEM_NOT_FOUND;

public class OrderNotFoundException extends OrderException{
    public OrderNotFoundException() {
        super(ORDER_ITEM_NOT_FOUND.getHttpStatus(),
                ORDER_ITEM_NOT_FOUND.getMessage());
    }
}
