package com.project.mini.backend.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.project.mini.backend.dto.User;

@Mapper
public interface UserMapper {
	@Insert("INSERT INTO user(id, password, name, email, address) VALUES("//
			+ "#{user.id}, " //
			+ "#{user.password}, " //
			+ "#{user.name}, " //
			+ "#{user.email}, " //
			+ "#{user.address})" //
	)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(@Param("user") User user);
	
	@Select("SELECT * FROM user")
	@Results(id="UserMap", value={
		@Result(property="id", column="id"),
		@Result(property="password", column="password"),
		@Result(property="name", column="name"),
		@Result(property="email", column="email"),
		@Result(property="adress", column="adress"),
		@Result(property="productList", column="id", many=@Many(select="com.project.mini.backend.dao.ProductMapper.getByProductUserId"))
	})
	List<User> getAll();
	
	@Select("SELECT * FROM user WHERE id=#{id}")
	@ResultMap("UserMap")
	User getById(@Param("id") String id);
}
