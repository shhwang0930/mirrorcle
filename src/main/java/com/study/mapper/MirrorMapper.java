package com.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.json.simple.JSONObject;

import com.study.model.MirrorProfile;




@Mapper
public interface MirrorMapper {
	//시리얼 넘버 넣기
	@Update("UPDATE mirror SET Account_index = #{accountIndex} WHERE serial_num = #{serialNum}")
	void connectMirror(@Param("serialNum") String serialNum, @Param("accountIndex") int accountIndex);
	
	//id, pw로 맞는 미러 idx 반환
	@Select("SELECT mirror_idx from mirror left outer join account on mirror.account_index = account.account_idx where account_id =#{acc_id} and account_pw =sha2(#{acc_pw},256)")
	int loginMirror(@Param("acc_id") String acc_id, @Param("acc_pw") String acc_pw);
	
	//버튼 눌렀을 때 맞는 유저 출력
	@Select("SELECT user_idx FROM user LEFT OUTER JOIN account ON user.account_index = account.account_idx JOIN mirror ON account.account_idx = mirror.account_index WHERE serial_num = #{serialNum}")
	List<Integer> selectMirror(@Param("serialNum") String serialNum);
	
	//최근에 불러온 유저 삽입
	@Update("UPDATE account LEFT OUTER JOIN mirror ON account.account_idx = mirror.account_index SET change_user =#{changeUser} WHERE serial_num = #{serialNum}")
	void updateChangeUser(@Param("changeUser") int changeUser, @Param("serialNum") String serialNum);
	
	//최근에 불러온 유저 반환
	@Select("SELECT change_user from account left outer join mirror on account.account_idx = mirror.account_index where serial_num =#{serialNum}")
	int selectChangeUser(@Param("serialNum") String serialNum);
	
	//최근에 불러온 유저의 템플릿 반환
	@Select("SELECT user_template from user where user_idx = #{changeUser}")
	JSONObject selectChangeTemplate(@Param("changeUser") int changeUser);
	
	//pir 절전 유무
	@Update("UPDATE mirror SET pir_sensor =#{pirSensor} WHERE serial_num = #{serialNum}")
	void pirSense(@Param("serialNum") String serialNum, @Param("pirSensor") int pirSensor);
	
	//pir 센서 반환
	@Select("SELECT pir_sensor FROM mirror WHERE serial_num = #{serialNum}")
	int reSensor(@Param("serialNum") String serialNum);
	
	@Select("SELECT serial_num FROM mirror WHERE Account_index = #{accountIndex}")
	JSONObject returnAccidx(@Param("accountIndex") int accountIndex);
}
