package com.example.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.mongo.dao.Person;

public interface PersonRepository extends MongoRepository<Person, Integer>{

	@Query("{first_name: ?0}")
	public List<Person> findByFirstName(String firstName);
	
	@Query( value = "{last_name: ?0}", fields = "{first_name: 1, last_name: 1}")
	public List<Person> findByLastName(String lastName);
}
