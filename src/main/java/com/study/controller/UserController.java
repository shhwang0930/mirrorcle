package com.study.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONObject;

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
	public void putUser(@RequestParam("userId") String userId, @RequestParam("accountIdx") int accountIdx) {
		mapper.insertUser(userId, accountIdx);
	}
	
	//유저삭제
	@DeleteMapping("/")
	public void deleteUser(@RequestParam("accountIdx") int accountIdx, @RequestParam("userId") String userId) {
		mapper.deleteUser(accountIdx, userId);
	}
	
	// 유저선택
	@GetMapping("/select")
	public List<UserProfile> selectUser(@RequestParam("accountIdx") int accountIdx, @RequestParam("userId") String userId) {
		return mapper.selectUser(accountIdx, userId);
	}
	
	//로그인후 해당 계정 유저 반환
	@GetMapping("/allselect")
	public List<UserProfile> selectAllacc(@RequestParam("accountIdx") int accountIdx) {
		return mapper.selectAllacc(accountIdx);
	}
	//유저 템플릿 수정
	@PutMapping("/template")
	public void putTemplate(@RequestParam("accountIdx") int accountIdx, @RequestParam("userId") String userId, @RequestParam String userTemplate) {
		mapper.putTemplate(accountIdx, userId, userTemplate);
	}
	
	// 템플릿 저장
     @GetMapping("/json")
     public JSONArray jsonReturn() {
    	 JSONObject jsonObject1 = new JSONObject();
    	 JSONObject jsonObject1XY = new JSONObject();
    	 JSONObject jsonObject1HW= new JSONObject();
    	 JSONObject jsonObject2XY = new JSONObject();
    	 JSONObject jsonObject2HW= new JSONObject();
    	 JSONObject jsonObject3XY = new JSONObject();
    	 JSONObject jsonObject3HW= new JSONObject();
    	 JSONObject jsonObject2 = new JSONObject();
    	 JSONObject jsonObject3 = new JSONObject();
    	 
    	 jsonObject1XY.put("x", 0);
    	 jsonObject1XY.put("y", 0);
    	 jsonObject1HW.put("height", 2);
    	 jsonObject1HW.put("width", 2);
    	 jsonObject1.put("coordinate",jsonObject1XY);
         jsonObject1.put("module_name","시계");
         jsonObject1.put("size",jsonObject1HW);
         
         jsonObject2XY.put("x", 4);
    	 jsonObject2XY.put("y", 0);
    	 jsonObject2HW.put("height", 1);
    	 jsonObject2HW.put("width", 1);
         jsonObject2.put("coordinate",jsonObject2XY);
         jsonObject2.put("module_name","날씨");
         jsonObject2.put("size",jsonObject2HW);
         
         jsonObject3XY.put("x", 3);
    	 jsonObject3XY.put("y", 4);
    	 jsonObject3HW.put("height", 3);
    	 jsonObject3HW.put("width", 2);
         jsonObject3.put("coordinate",jsonObject3XY);
         jsonObject3.put("module_name","교통정보");
         jsonObject3.put("size",jsonObject3HW);
         
         
  
         
         JSONArray req_array = new JSONArray();
         req_array.add(jsonObject1);
         req_array.add(jsonObject2);
         req_array.add(jsonObject3);
         
         return req_array;
     }
}
