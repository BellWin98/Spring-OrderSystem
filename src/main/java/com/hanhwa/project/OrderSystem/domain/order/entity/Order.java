package com.hanhwa.project.OrderSystem.domain.order.entity;

import com.hanhwa.project.OrderSystem.domain.member.entity.Member;
import com.hanhwa.project.OrderSystem.domain.order.exception.OrderItemNotFoundException;
import com.hanhwa.project.OrderSystem.global.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
public class Order extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int totalPrice;

    @Column
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus orderStatus;

    @JoinColumn(name = "member_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    @Builder
    public Order(Member member, OrderStatus orderStatus, List<OrderItem> orderItems){
        this.member = member;
        this.orderStatus = orderStatus;
        this.address = member.getAddress();
        validateOrderItems(orderItems);
        createOrderName(orderItems);
        setOrderItems(orderItems);
        calculateTotalPrice();
    }

    public void changeStatus(OrderStatus orderStatus){
        this.orderStatus = orderStatus;
    }

    public void cancelOrder(){
        this.orderStatus = OrderStatus.CANCELED;
        for (OrderItem orderItem : orderItems){
            orderItem.cancel();
        }
    }

    // 주문명 생성
    private void createOrderName(final List<OrderItem> orderItems) {
        this.name = (orderItems.size() == 1) ?
                orderItems.get(0).getItem().getName() :
                orderItems.get(0).getItem().getName() + " 외 " + (orderItems.size() - 1) + "개";
    }

    // Order 테이블에 주문한 상품 세팅과 동시에 OrderItem에 Order 정보 저장
    private void setOrderItems(List<OrderItem> orderItems){
        this.orderItems = orderItems;
        for (OrderItem orderItem : orderItems){
            orderItem.setOrder(this);
        }
    }

    // 주문 총액 계산
    private void calculateTotalPrice() {
        int totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.calculateSubTotal();
        }
        this.totalPrice = totalPrice;
    }

    // 주문 상품이 없으면 주문 생성 불가
    private void validateOrderItems(List<OrderItem> orderItems) throws OrderItemNotFoundException{
        if (orderItems.isEmpty()){
            throw new OrderItemNotFoundException();
        }
    }
}
