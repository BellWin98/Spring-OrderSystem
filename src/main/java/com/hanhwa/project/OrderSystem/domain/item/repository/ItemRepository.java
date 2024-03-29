package com.hanhwa.project.OrderSystem.domain.item.repository;

import com.hanhwa.project.OrderSystem.domain.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
