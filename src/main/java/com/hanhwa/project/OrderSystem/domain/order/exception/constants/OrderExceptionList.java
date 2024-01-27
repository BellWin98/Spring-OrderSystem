package com.hanhwa.project.OrderSystem.domain.order.exception.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum OrderExceptionList {
    ORDER_ITEM_NOT_FOUND(HttpStatus.BAD_REQUEST, "주문 아이템이 비어있습니다."),
    ORDER_NOT_FOUND(HttpStatus.BAD_REQUEST, "해당 ID의 주문이 존재하지 않습니다."),
    ORDER_ALREADY_CANCELED(HttpStatus.BAD_REQUEST, "이미 취소된 주문입니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
