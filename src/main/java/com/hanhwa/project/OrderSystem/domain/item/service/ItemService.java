package com.hanhwa.project.OrderSystem.domain.item.service;

import com.hanhwa.project.OrderSystem.domain.item.dto.request.ItemCreateRequest;
import com.hanhwa.project.OrderSystem.domain.item.dto.response.ItemResponse;
import com.hanhwa.project.OrderSystem.domain.item.entity.Item;
import com.hanhwa.project.OrderSystem.domain.item.repository.ItemRepository;
import com.hanhwa.project.OrderSystem.domain.member.dto.response.MemberResponse;
import com.hanhwa.project.OrderSystem.domain.member.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public ItemResponse registerItem(ItemCreateRequest req){
        log.info("registerItem Service start");
        return ItemResponse.from(itemRepository.save(req.toEntity()));
    }

    public List<ItemResponse> getItems(){
        log.info("getItems Service start");
        List<Item> items = itemRepository.findAll();
        List<ItemResponse> itemResponses = new ArrayList<>();
        for (Item item : items){
            itemResponses.add(ItemResponse.from(item));
        }
        log.info("getItems Service end");
        return itemResponses;
    }
}
