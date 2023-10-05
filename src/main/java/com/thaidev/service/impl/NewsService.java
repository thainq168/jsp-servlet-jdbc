package com.thaidev.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.thaidev.dao.INewsDAO;
import com.thaidev.model.NewsModel;
import com.thaidev.service.INewsService;

public class NewsService implements INewsService{

	@Inject
	private INewsDAO newsDao;
	
	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		return newsDao.findByCategoryId(categoryId);
	}

	@Override
	public NewsModel save(NewsModel newsModel) {
		newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newsModel.setCreatedBy("");
		Long newsId = newsDao.save(newsModel); 
		return newsDao.findOne(newsId);
	}

	@Override
	public NewsModel update(NewsModel updateNews) {
		NewsModel oldNews = newsDao.findOne(updateNews.getId());
		updateNews.setCreatedDate(oldNews.getCreatedDate());
		updateNews.setCreatedBy(oldNews.getCreatedBy());
		updateNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNews.setModifiedBy("");
		newsDao.update(updateNews);
		return newsDao.findOne(updateNews.getId());
	}

	@Override
	public void delete(long[] ids) {
		for(long id : ids) {
			// delete comment first (foreign key)
			newsDao.delete(id);
		}
	}
	

}
