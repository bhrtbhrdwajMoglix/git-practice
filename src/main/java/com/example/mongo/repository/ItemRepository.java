package com.example.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.mongo.dao.Item;

public interface ItemRepository extends MongoRepository<Item, Integer> {
	public List<Item> findByItemName(String itemName);
	
	@Query("{$and: [{item_price: {$gt: 12}},{ item_price: {$exists: true}}]}")
	public List<Item> find();
}
