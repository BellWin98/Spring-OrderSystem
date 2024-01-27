package com.hanhwa.project.OrderSystem.domain.item.dto.response;

import com.hanhwa.project.OrderSystem.domain.item.entity.Item;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItemResponse {
    private String name;
    private int price;
    private int stockQuantity;

    public static ItemResponse from(Item item){
        return ItemResponse.builder()
                .name(item.getName())
                .price(item.getPrice())
                .stockQuantity(item.getStockQuantity())
                .build();
    }
}
