package com.study.controller;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.mapper.AccountMapper;
import com.study.mapper.ApiMapper;

@RestController()
@RequestMapping("/api")
public class ApiController {
private ApiMapper mapper;
	
	public ApiController(ApiMapper mapper) {
		this.mapper = mapper;
	}
	@GetMapping("/select")
	public JSONObject selectApi(@RequestParam("name") String name) {
		return mapper.selectApi(name);
	}
}
