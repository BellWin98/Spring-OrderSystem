package com.hanhwa.project.OrderSystem.domain.item.entity;

import com.hanhwa.project.OrderSystem.domain.member.entity.Member;
import com.hanhwa.project.OrderSystem.domain.order.entity.OrderStatus;
import com.hanhwa.project.OrderSystem.global.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int stockQuantity;

    @Column
    private String imagePath;

    @Builder
    public Item(String name, int price, int stockQuantity, String imagePath){
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.imagePath = imagePath;
    }

    public void decreaseStockQuantity(int quantity) {
        this.stockQuantity -= quantity;
    }

    public void increaseStockQuantity(int quantity) {
        this.stockQuantity += quantity;
    }
}
