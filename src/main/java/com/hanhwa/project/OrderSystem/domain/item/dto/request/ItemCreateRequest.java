package com.hanhwa.project.OrderSystem.domain.item.dto.request;

import com.hanhwa.project.OrderSystem.domain.item.entity.Item;
import com.hanhwa.project.OrderSystem.domain.member.entity.Member;
import com.hanhwa.project.OrderSystem.domain.member.entity.Role;
import lombok.Data;

@Data
public class ItemCreateRequest {
    private String name;
    private int price;
    private int stockQuantity;
    private String imagePath;
    public Item toEntity(){
        return Item.builder()
                .name(name)
                .price(price)
                .stockQuantity(stockQuantity)
                .imagePath(imagePath)
                .build();
    }
}
