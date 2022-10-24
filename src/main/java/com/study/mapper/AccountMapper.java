package com.study.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.json.simple.JSONObject;

import com.study.model.*;

@Mapper
public interface AccountMapper {

	@Insert("INSERT INTO account(Account_id, Account_pw, Account_email, Account_name) VALUES(#{id}, #{pw}, #{email}, #{name})")
	int insertAccountProfile(@Param("id") String id,@Param("pw") String pw,@Param("email") String email,@Param("name") String name);
	
	@Delete("DELETE FROM account WHERE Account_id = #{id}")
	int deleteAccountProfile(@Param("id") String id);
	
	@Select("SELECT count(*) FROM account WHERE Account_id =#{id}")
	int checkAccountId(@Param("id") String id);
	
	@Select("SELECT Account_idx FROM account WHERE Account_id = #{id} AND Account_pw = #{pw}")
	JSONObject loginAccount(@Param("id") String id, @Param("pw") String pw);
	
	@Select("SELECT Account_id FROM account WHERE Account_name = #{name} AND Account_email = #{email}")
	JSONObject findAccountId(@Param("name") String name, @Param("email") String email);
	
	@Select("SELECT Account_Idx FROM account WHERE Account_id = #{id} AND Account_name = #{name} AND Account_email = #{email}")
	JSONObject findAccountPw(@Param("id") String id, @Param("name") String name, @Param("email") String email);
	
	@Update("UPDATE account SET Account_pw = #{pw} WHERE Account_idx = #{idx}")
	int createAccountPw(@Param("pw") String pw, @Param("idx") int idx);
	
	@Select("SELECT count(*) FROM mirror LEFT OUTER JOIN account ON account.account_idx = mirror.account_index WHERE Account_id =#{id} AND Account_pw =#{pw}")
	int isConnectMirror(@Param("id") String id, @Param("pw") String pw);
	
	@Select("SELECT mirror_idx FROM mirror LEFT OUTER JOIN account ON account.account_idx = mirror.account_index WHERE Account_id =#{id} AND Account_pw =#{pw}")
	int ConnectMirror(@Param("id") String id, @Param("pw") String pw);
}
