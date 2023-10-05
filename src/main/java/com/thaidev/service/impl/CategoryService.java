package com.thaidev.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.thaidev.dao.ICategoryDAO;
import com.thaidev.model.CategoryModel;
import com.thaidev.service.ICategoryService;

public class CategoryService implements ICategoryService{

	@Inject
	private ICategoryDAO categoryDAO;
	
	@Override
	public List<CategoryModel> findAll() {

		return categoryDAO.findAll();
	}

}
