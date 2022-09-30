package com.study.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.mapper.UserMapper;
import com.study.model.*;

@RestController()
@RequestMapping("/user")
public class UserController {
	
	private UserMapper mapper;
	
	public UserController(UserMapper mapper) {
		this.mapper = mapper;
	}
	//유저생성
	@PutMapping("/create")
	public void putUser(@RequestParam("userId") String userId) {
		mapper.insertUser(userId);
	}
	
	//유저삭제
	@DeleteMapping("/delete")
	public void deleteUser(@PathVariable("userId") String userId) {
		mapper.deleteUser(userId);
	}
}
