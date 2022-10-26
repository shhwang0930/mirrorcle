package com.study.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
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
	@GetMapping("/idcheck")
	public JSONObject checkAccountId(@RequestParam("id") String id) {
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
		JSONObject login = new JSONObject();
		JSONObject loginRes = mapper.loginAccount(id, pw);
		if(loginRes == null) {
			login.put("status", 500);
		} else {
			if(mapper.isConnectMirror(id, pw) == 1) {
				loginRes.put("mirrorIdx", mapper.ConnectMirror(id, pw));
			}
			else {
				loginRes.put("mirrorIdx", null);
			}
			loginRes.put("status", 200);
			login = loginRes;
		}
		return login;
	}
	//아이디 찾기
	@GetMapping("/idfind")
	public JSONObject findAccountId(@RequestParam("name") String name,@RequestParam("email") String email ) {
		JSONObject idfind = new JSONObject();
		JSONObject idfindRes = mapper.findAccountId(name, email);
		if(idfindRes == null) {
			idfind.put("status", 500);
		}
		else {
			idfindRes.put("status", 200);
			idfind = idfindRes;
		}
		return  idfind;
	}
	
	//pw찾기 1) pw찾기 위한 정보 입력 
	@GetMapping("/pwfind")
	public JSONObject findAccountPw(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("email") String email ) {
		JSONObject pwfind = new JSONObject();
		JSONObject pwfindRes = mapper.findAccountPw(id, name, email);
		if(pwfindRes == null) {
			pwfind.put("status", 500);
		}
		else {
			pwfindRes.put("status", 200);
			pwfind = pwfindRes;
		}
		return pwfind;
	}
	
	//pw찾기 2) 새로운 pw 입력 및 저장
	@PutMapping("/pwcreate")
	public void createAccountPw(@RequestParam("idx") int idx, @RequestParam("pw") String pw) {
		mapper.createAccountPw(pw, idx);
	}
}
