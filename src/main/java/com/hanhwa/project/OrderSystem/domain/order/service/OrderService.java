package com.hanhwa.project.OrderSystem.domain.order.service;

import com.hanhwa.project.OrderSystem.domain.item.entity.Item;
import com.hanhwa.project.OrderSystem.domain.item.exception.ItemInsufficientException;
import com.hanhwa.project.OrderSystem.domain.item.exception.ItemNotFoundException;
import com.hanhwa.project.OrderSystem.domain.item.repository.ItemRepository;
import com.hanhwa.project.OrderSystem.domain.member.entity.Member;
import com.hanhwa.project.OrderSystem.domain.member.exception.MemberNotFoundException;
import com.hanhwa.project.OrderSystem.domain.member.repository.MemberRepository;
import com.hanhwa.project.OrderSystem.domain.order.dto.request.OrderCreateRequest;
import com.hanhwa.project.OrderSystem.domain.order.dto.request.OrderCreateRequest.OrderItemCreateRequest;
import com.hanhwa.project.OrderSystem.domain.order.dto.response.OrderCreateResponse;
import com.hanhwa.project.OrderSystem.domain.order.dto.response.OrderItemResponse;
import com.hanhwa.project.OrderSystem.domain.order.entity.Order;
import com.hanhwa.project.OrderSystem.domain.order.entity.OrderItem;
import com.hanhwa.project.OrderSystem.domain.order.entity.OrderStatus;
import com.hanhwa.project.OrderSystem.domain.order.exception.OrderAlreadyCanceledException;
import com.hanhwa.project.OrderSystem.domain.order.exception.OrderNotFoundException;
import com.hanhwa.project.OrderSystem.domain.order.repository.OrderItemRepository;
import com.hanhwa.project.OrderSystem.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final OrderItemRepository orderItemRepository;

    // 주문
    @Transactional
    public OrderCreateResponse createOrder(OrderCreateRequest req){
        log.info("createOrder service start");
        Member findMember = memberRepository.findById(req.getMemberId())
                .orElseThrow(MemberNotFoundException::new);
        List<OrderItem> orderItems = createOrderItem(req.getOrderItems());
        Order order = Order.builder()
                .member(findMember)
                .orderItems(orderItems)
                .orderStatus(OrderStatus.ORDERED)
                .build();
        log.info("createOrder service end");
        return OrderCreateResponse.from(orderRepository.save(order));
    }

    // 주문 상품 목록 조회
    public List<OrderItemResponse> getOrderItems(Long orderId){
        Order findOrder = orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
        List<OrderItemResponse> orderItemResponses = new ArrayList<>();
        for (OrderItem orderItem : findOrder.getOrderItems()){
            orderItemResponses.add(OrderItemResponse.from(orderItem));
        }
        return orderItemResponses;
    }

    // 주문 취소
    @Transactional
    public void cancelOrder(Long orderId) throws OrderAlreadyCanceledException{
        Order findOrder = orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
        if (findOrder.getOrderStatus() == OrderStatus.CANCELED){
            throw new OrderAlreadyCanceledException();
        }
        findOrder.cancelOrder();
    }

    private List<OrderItem> createOrderItem(List<OrderItemCreateRequest> orderItemCreateRequests) {
        log.info("createOrderItem service start");
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemCreateRequest orderItemCreateRequest : orderItemCreateRequests) {
            Item findItem = itemRepository.findById(orderItemCreateRequest.getItemId())
                    .orElseThrow(ItemNotFoundException::new);
            int quantity = orderItemCreateRequest.getQuantity();
            validateItemStockQuantity(findItem, quantity);
            findItem.decreaseStockQuantity(quantity);
            OrderItem orderItem = new OrderItem(findItem, quantity);
            orderItems.add(orderItem);
        }
        log.info("createOrderItem service end");
        return orderItems;
    }

    private void validateItemStockQuantity(Item findItem, int quantity){
        if (findItem.getStockQuantity() - quantity < 0){
            throw new ItemInsufficientException();
        }
    }
}
