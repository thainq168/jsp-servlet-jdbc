package com.thaidev.dao;

import java.util.List;

import com.thaidev.model.NewsModel;
import com.thaidev.paging.Pageable;

public interface INewsDAO {
	NewsModel findOne(Long id);
	List<NewsModel> findByCategoryId(Long categoryId);
	Long save(NewsModel newsModel);
	void update(NewsModel updateNews);
	void delete(long id);
	List<NewsModel> findAll(Pageable pageable);
	int getTotalItem();
}
