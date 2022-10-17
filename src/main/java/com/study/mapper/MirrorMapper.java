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
	@Update("UPDATE mirror SET Account_index = #{accountIdx} WHERE serial_num = #{serialNum}")
	void connectMirror(@Param("serialNum") String serialNum, @Param("accountIndex") int accountIndex);
	
	//id, pw로 맞는 미러 idx 반환
	@Select("SELECT mirror_idx from mirror left outer join account on mirror.account_index = account.account_idx where account_id =#{acc_id} and account_pw =#{acc_pw}")
	int loginMirror(@Param("acc_id") String acc_id, @Param("acc_pw") String acc_pw);
	
	//버튼 눌렀을 때 맞는 유저 출력
	@Select("SELECT user_idx FROM user LEFT OUTER JOIN account ON user.account_index = account.account_idx JOIN mirror ON account.account_idx = mirror.account_index WHERE mirror_idx = #{mirrorIdx}")
	List<MirrorProfile> selectMirror();
}
