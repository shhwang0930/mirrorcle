package com.study.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
	
	@Insert("INSERT INTO user(user_Id) VALUES(#{userId})")
	int insertUser(@Param("userId")String userId);
	
	@Delete("DELETE FROM user WHERE user_id = #{userId}")
	int deleteUser(@Param("userId") String userId);
}
