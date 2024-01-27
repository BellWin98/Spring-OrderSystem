package com.hanhwa.project.OrderSystem.domain.item.exception.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ItemExceptionList {
    ITEM_NOT_FOUND(HttpStatus.BAD_REQUEST, "해당 ID의 상품을 찾을 수 없습니다."),
    ITEM_INSUFFICIENT(HttpStatus.BAD_REQUEST, "해당 상품의 재고 수량이 부족합니다.");

    private final HttpStatus httpStatus;
    private final String message;
}

