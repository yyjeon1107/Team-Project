package com.project.mini.backend.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.project.mini.backend.dto.Product;

@Mapper
public interface ProductMapper {
	@Insert("INSERT INTO product(userId, name, info) VALUES("//
			+ "#{product.userId}, " //
			+ "#{product.name}, " //
			+ "#{product.info})" //
	)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(@Param("product") Product product);
	
	@Select("SELECT * FROM product")
	@Results(id="ProductMap", value={
		@Result(property="id", column="id"),
		@Result(property="userId", column="userId"),
		@Result(property="name", column="name"),
		@Result(property="info", column="info"),
	})
	List<Product> getAll();
	
	@Select("SELECT * FROM product WHERE id=#{id}")
	@ResultMap("ProductMap")
	Product getById(@Param("id") int id);

	@Select("SELECT * FROM product WHERE userId=#{userId}")
	@ResultMap("ProductMap")
	List<Product> getByProductUserId(@Param("userId") String userId);
}
