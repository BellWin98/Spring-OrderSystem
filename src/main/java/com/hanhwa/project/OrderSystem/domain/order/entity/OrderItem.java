package com.hanhwa.project.OrderSystem.domain.order.entity;

import com.hanhwa.project.OrderSystem.domain.item.entity.Item;
import com.hanhwa.project.OrderSystem.global.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// 아이템 별 주문
public class OrderItem extends BaseTimeEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private int quantity;

        @JoinColumn(name = "order_id", nullable = false)
        @ManyToOne(fetch = FetchType.LAZY)
        private Order order;

        @JoinColumn(name = "item_id", nullable = false)
        @ManyToOne(fetch = FetchType.LAZY)
        private Item item;

    public OrderItem(Item item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }

    public void setOrder(Order order){
        this.order = order;
    }

    public void cancel(){
        this.getItem().increaseStockQuantity(quantity);
    }

    public int calculateSubTotal(){
        return item.getPrice() * quantity;
    }
}
