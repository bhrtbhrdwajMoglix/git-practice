package com.example.mongo.controller;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.dao.Item;
import com.example.mongo.itemdto.ItemDto;
import com.example.mongo.repository.ItemRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/items")
@Api("MongoDB Item collection")
public class ItemController {
	@Autowired
	private ItemRepository repo;
	
	@ApiOperation(value = "getItems", notes = "finds item which have price and price greater than 0", response = Iterable.class)
	@GetMapping
	public ResponseEntity<List<Item>> getItems(){
		//return new ResponseEntity<>(repo.findByItemName("A"), HttpStatus.OK);
		return new ResponseEntity<>(repo.find(), HttpStatus.OK);
		
	}
	@PostMapping
	@ApiOperation(value = "createItem", notes = "creates an item", response = ItemDto.class)
	public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto){
		int id = new Random().nextInt();
		Item item = repo.save(new Item(id, itemDto.getItemName(), itemDto.getItemPrice()));
		return new ResponseEntity<ItemDto>(new ItemDto(item), HttpStatus.CREATED);}
	
	@ApiOperation(value = "getItem", notes = "Get item by name.", response = Iterable.class)
	@GetMapping("/{itemName}")
	public ResponseEntity<List<ItemDto>> getItemByName(@ApiParam(value = "Item Name", required = true)
	@PathVariable String itemName){
		List<Item> item = (List<Item>)repo.findByItemName(itemName);
		if(item.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		List<ItemDto> dto = item.stream().map((i)-> new ItemDto(i)).collect(Collectors.toList());
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
