package com.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.study.model.UserProfile;

@Mapper
public interface UserMapper {
	
	@Insert("INSERT INTO user(user_Id, Account_Index) VALUES(#{userId}, #{accountIdx})")
	int insertUser(@Param("userId")String userId, @Param("accountIdx")int accountIdx);
	
	@Delete("DELETE FROM user WHERE Account_index = #{accountIdx} AND user_id = #{userId}")
	int deleteUser(@Param("accountIdx") int  accountIdx, @Param("userId") String userId);
	
	@Select("SELECT * FROM user WHERE Account_index = #{accountIdx} AND user_id = #{userId}")
	List<UserProfile> selectUser(@Param("accountIdx") int  accountIdx, @Param("userId") String userId);
	
	@Select("SELECT * FROM user WHERE Account_index = #{accountIdx}")
	List<UserProfile> selectAllacc(@Param("accountIdx") int  accountIdx);
	
	@Update("UPDATE user SET user_Template = #{userTemplate} WHERE Account_index = #{accountIdx} AND user_id = #{userId}")
	int putTemplate(@Param("accountIdx") int  accountIdx, @Param("userId") String userId, @Param("userTemplate") String userTemplate);
}
