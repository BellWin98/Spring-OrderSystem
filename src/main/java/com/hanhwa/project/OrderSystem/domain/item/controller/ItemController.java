package com.hanhwa.project.OrderSystem.domain.item.controller;

import com.hanhwa.project.OrderSystem.domain.item.dto.request.ItemCreateRequest;
import com.hanhwa.project.OrderSystem.domain.item.dto.response.ItemResponse;
import com.hanhwa.project.OrderSystem.domain.item.entity.Item;
import com.hanhwa.project.OrderSystem.domain.item.service.ItemService;
import com.hanhwa.project.OrderSystem.domain.member.dto.response.MemberResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @PostMapping("/item/new")
    public ResponseEntity<ItemResponse> registerItem(@RequestBody ItemCreateRequest req){
        log.info("registerItem Service start");
        return new ResponseEntity<>(itemService.registerItem(req), HttpStatus.CREATED);
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemResponse>> getItems(){
        return new ResponseEntity<>(itemService.getItems(), HttpStatus.OK);
    }
}
