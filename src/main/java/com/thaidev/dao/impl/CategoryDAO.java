package com.thaidev.dao.impl;

import java.util.List;

import com.thaidev.dao.ICategoryDAO;
import com.thaidev.mapper.CategoryMapper;
import com.thaidev.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		
		String sql = "select * from category";	 
		return query(sql, new CategoryMapper());
		
	}
}
