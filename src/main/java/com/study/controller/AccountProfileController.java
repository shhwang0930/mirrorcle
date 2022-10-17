package com.study.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.json.simple.JSONObject;
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
	
	
	
	//아이디 중복확인
	@GetMapping("/idcheck/{id}")
	public JSONObject checkAccountId(@PathVariable("id") String id) {
		JSONObject idcheckJson = new JSONObject();
		if(mapper.checkAccountId(id) > 0){
			idcheckJson.put("idcheck", 0);
			return idcheckJson;//아이디 중복
		}	
		else{
			idcheckJson.put("idcheck", 1);
			return idcheckJson;//아이디 사용가능
		}
	}
	//로그인
	@PostMapping("/login")
	public JSONObject loginAccount(@RequestParam("id") String id, @RequestParam("pw") String pw) {
		JSONObject loginJson = new JSONObject();
		loginJson.put("index", mapper.loginAccount(id, pw));
		return loginJson;
		
	}
	//아이디 찾기
	@GetMapping("/idfind")
	public JSONObject findAccountId(@RequestParam("name") String name,@RequestParam("email") String email ) {
		JSONObject returnId = new JSONObject();
		returnId.put("id", mapper.findAccountId(name, email));
		return returnId;
	}
	
	//pw찾기 1) pw찾기 위한 정보 입력 
	@GetMapping("/pwfind")
	public JSONObject findAccountPw(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("email") String email ) {
		JSONObject pwfindJson = new JSONObject();
		pwfindJson.put("index", mapper.findAccountPw(id, name, email));
		return pwfindJson;
	}
	
	//pw찾기 2) 새로운 pw 입력 및 저장
	@PutMapping("/pwcreate/{idx}")
	public void createAccountPw(@PathVariable("idx") int idx, @RequestParam("pw") String pw) {
		mapper.createAccountPw(pw, idx);
	}
}
