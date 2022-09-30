package com.study.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.study.model.*;

@Mapper
public interface AccountMapper {
	
	
	
	@Insert("INSERT INTO account(Account_id, Account_pw, Account_email, Account_name) VALUES(#{id}, #{pw}, #{email}, #{name})")
	int insertAccountProfile(@Param("id") String id,@Param("pw") String pw,@Param("email") String email,@Param("name") String name);
	
	@Delete("DELETE FROM account WHERE Account_id = #{id}")
	int deleteAccountProfile(@Param("id") String id);
	
	@Select("SELECT * FROM account WHERE Account_id =#{id}")
	int checkAccountId(@Param("id") String id);
	
	@Select("SELECT * FROM account WHERE Account_id = #{id} AND Account_pw = #{pw}")
	int loginAccount(@Param("id") String id, @Param("pw") String pw);
}
