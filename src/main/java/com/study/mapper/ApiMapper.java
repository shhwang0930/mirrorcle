package com.study.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.json.simple.JSONObject;

@Mapper
public interface ApiMapper {
	@Select("SELECT api_key FROM api WHERE name = #{name}")
	JSONObject selectApi(@Param("name") String name);
}
