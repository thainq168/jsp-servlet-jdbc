package com.thaidev.service;

import java.util.List;

import com.thaidev.model.NewsModel;

public interface INewsService {

	List<NewsModel> findByCategoryId(Long categoryId);
	NewsModel save(NewsModel newsModel);
	NewsModel update(NewsModel updateNews);
	void delete(long[] ids);
}
