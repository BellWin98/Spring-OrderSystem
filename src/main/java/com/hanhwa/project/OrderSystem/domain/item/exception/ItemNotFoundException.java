package com.hanhwa.project.OrderSystem.domain.item.exception;

import static com.hanhwa.project.OrderSystem.domain.item.exception.constants.ItemExceptionList.ITEM_NOT_FOUND;

public class ItemNotFoundException extends ItemException{
    public ItemNotFoundException() {
        super(ITEM_NOT_FOUND.getHttpStatus(),
                ITEM_NOT_FOUND.getMessage());
    }
}
