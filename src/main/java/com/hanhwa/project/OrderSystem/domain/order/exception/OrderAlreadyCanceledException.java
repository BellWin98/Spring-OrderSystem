package com.hanhwa.project.OrderSystem.domain.order.exception;

import static com.hanhwa.project.OrderSystem.domain.order.exception.constants.OrderExceptionList.ORDER_ALREADY_CANCELED;
import static com.hanhwa.project.OrderSystem.domain.order.exception.constants.OrderExceptionList.ORDER_ITEM_NOT_FOUND;

public class OrderAlreadyCanceledException extends OrderException{
    public OrderAlreadyCanceledException() {
        super(ORDER_ALREADY_CANCELED.getHttpStatus(),
                ORDER_ALREADY_CANCELED.getMessage());
    }
}
