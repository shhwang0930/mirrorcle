package com.study.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.study.mapper.MirrorMapper;
import com.study.model.*;

@RestController()
@RequestMapping("/mirror")
public class MirrorController {
	private MirrorMapper mapper;
	
	public MirrorController(MirrorMapper mapper) {
		this.mapper = mapper;
	}
	
	//미러 계정 연결
	@PutMapping("/connect")
	public void connectMirror(@RequestParam("serialNum") String serialNum, @RequestParam("accountIndex") int accountIndex) {
		mapper.connectMirror(serialNum, accountIndex);
	}
	@PostMapping("/login")
	public int loginMirror(@RequestParam("acc_id") String acc_id, @RequestParam("acc_pw") String acc_pw) {
		return mapper.loginMirror(acc_id, acc_pw);
	}
	
	@GetMapping("/useridx")
	public List<MirrorProfile> selectMirror(){
		return mapper.selectMirror();
	}
	
}
