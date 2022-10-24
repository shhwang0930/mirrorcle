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
	
	@Insert("INSERT INTO user(user_Id, Account_Index, user_image) VALUES(#{userId}, #{accountIdx}, #{userImage})")
	int insertUser(@Param("userId")String userId, @Param("accountIdx")int accountIdx, @Param("userImage")String userImage);
	
	@Delete("DELETE FROM user WHERE Account_index = #{accountIdx} AND user_idx = #{userIdx}")
	int deleteUser(@Param("accountIdx") int  accountIdx, @Param("userIdx") int userIdx);
	
	@Select("SELECT user_template FROM user WHERE Account_index = #{accountIdx} AND user_idx = #{userIdx}")
	JSONObject selectUser(@Param("accountIdx") int  accountIdx, @Param("userIdx") int userIdx);
	
	@Select("SELECT user_idx, user_id, user_image, Account_index FROM user WHERE Account_index = #{accountIdx}")
	List<UserProfile> selectAllacc(@Param("accountIdx") int  accountIdx);
	
	@Update("UPDATE user SET user_Template = #{userTemplate} WHERE Account_index = #{accountIdx} AND user_idx = #{userIdx}")
	int putTemplate(@Param("accountIdx") int  accountIdx, @Param("userIdx") int userIdx, @Param("userTemplate") String userTemplate);
	
	@Update("UPDATE user SET user_id =#{userId}, user_image=#{userImage} WHERE Account_index = #{accountIdx} AND user_idx = #{userIdx}")
	int updateUser(@Param("accountIdx") int  accountIdx, @Param("userIdx") int userIdx, @Param("userId")String userId, @Param("userImage")String userImage);
}
