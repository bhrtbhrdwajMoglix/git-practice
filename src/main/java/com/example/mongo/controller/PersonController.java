package com.example.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.dao.Person;
import com.example.mongo.repository.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonController {
	@Autowired
	private PersonRepository repo;
	
	@GetMapping
	public ResponseEntity<List<Person>> getAllPerson(){
		//return new ResponseEntity<List<Person>>(repo.findAll(), HttpStatus.OK);
		return new ResponseEntity<List<Person>>(repo.findByLastName("Bhardwaj"), HttpStatus.OK);
	}
}
