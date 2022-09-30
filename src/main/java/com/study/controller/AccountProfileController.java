package com.study.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.model.AccountProfile;
import com.study.mapper.*;

@RestController()
@RequestMapping("/account")
public class AccountProfileController {
	
	private AccountMapper mapper;
	
	public AccountProfileController(AccountMapper mapper) {
		this.mapper = mapper;
	}
	
	//회원가입 
	@PutMapping("/create")
	public void putAccountProfile(@RequestParam("id") String id, @RequestParam("pw") String pw, @RequestParam("email") String email, @RequestParam("name") String name) {
		mapper.insertAccountProfile(id, pw, email, name);
	}
	
	//회원삭제
	@DeleteMapping("/delete/{id}")
	public void deleteAccountProfile(@PathVariable("id") String id) {
		mapper.deleteAccountProfile(id);
	}
	
	//아이디 중복확인
	@GetMapping("/idcheck/{id}")
	public String checkAccountId(@PathVariable("id") String id) {
		if(mapper.checkAccountId(id) == 1) {
			return "아이디 사용가능";
		}
		else{
			return "아이디 중복";
		}
		
	}
	//로그인
	@PostMapping("/login")
	public String loginAccount(@RequestParam("id") String id, @RequestParam("pw") String pw) {
		if(mapper.loginAccount(id, pw) == 1) {
			return "로그인 성공";
		}else {
			return "로그인 실패";
		}
	}

}
