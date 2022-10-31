package com.study.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.study.mapper.MirrorMapper;
import com.study.model.*;

@CrossOrigin
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
	
	//로그인 후 미러 인덱스 리턴
	@PostMapping("/login")
	public int loginMirror(@RequestParam("acc_id") String acc_id, @RequestParam("acc_pw") String acc_pw) {
		return mapper.loginMirror(acc_id, acc_pw);
	}
	
	//버튼 값에 따른 user인덱스 리턴
	@GetMapping("/useridx")
	public int selectMirror(@RequestParam("serialNum") String serialNum, @RequestParam("button") int button){
		List<Integer> list = mapper.selectMirror(serialNum);
		int i = button-1;
		int changeUser = list.get(i);
		mapper.updateChangeUser(changeUser, serialNum);
		return list.get(i);
	}
	
	//현재 눌려진 유저 템플릿 반환 (폴링위함)
	@GetMapping("/changeuser")
	public JSONObject selectChangeUser(@RequestParam("serialNum") String serialNum) {
		int changeUser = mapper.selectChangeUser(serialNum);
		JSONObject changeuser = new JSONObject();
		JSONObject changeuserRes = mapper.selectChangeTemplate(changeUser);
		if(changeuserRes == null) {
			changeuser.put("status", 500);
		}
		else {
			changeuserRes.put("status", 200);
			changeuser = changeuserRes;
		}
		return  changeuser;
	}
	
	//미러 절전 데이터 삽입
	@PutMapping("/pir")
	public void pirSense(@RequestParam("serialNum") String serialNum, @RequestParam("pirSensor") int pirSensor) {
		mapper.pirSense(serialNum, pirSensor);
	}
	
	//미러 절전 데이터 반환
	@GetMapping("/returnpir")
	public int reSensor(@RequestParam("serialNum") String serialNum) {
		return mapper.reSensor(serialNum);
	}
	//앱에 반환될 시리얼 넘버
	@GetMapping("/serial")
	public JSONObject returnAccidx(@RequestParam("accountIndex") int accountIndex) {
		JSONObject serial = new JSONObject();
		JSONObject serialRes = mapper.returnAccidx(accountIndex);
		if(serialRes == null) {
			serial.put("status", 500);
		}
		else {
			serialRes.put("status", 200);
			serial = serialRes;
		}
		return  serial;
	}
}
