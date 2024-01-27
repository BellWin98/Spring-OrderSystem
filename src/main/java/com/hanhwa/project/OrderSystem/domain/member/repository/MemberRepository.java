package com.hanhwa.project.OrderSystem.domain.member.repository;

import com.hanhwa.project.OrderSystem.domain.member.entity.Member;
import com.hanhwa.project.OrderSystem.domain.order.entity.Order;
import com.hanhwa.project.OrderSystem.domain.order.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);

    @Query("select o from Order o where o.member.id = :id order by o.createdTime desc")
    List<Order> findMemberOrders(@Param("id") Long id);
}
