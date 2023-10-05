package com.thaidev.dao;

import java.util.List;

import com.thaidev.model.NewsModel;

public interface INewsDAO {
	NewsModel findOne(Long id);
	List<NewsModel> findByCategoryId(Long categoryId);
	Long save(NewsModel newsModel);
	void update(NewsModel updateNews);
	void delete(long id);
}
