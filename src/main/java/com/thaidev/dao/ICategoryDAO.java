package com.thaidev.dao;

import java.util.List;

import com.thaidev.model.CategoryModel;

public interface ICategoryDAO {

	List<CategoryModel> findAll();
}
