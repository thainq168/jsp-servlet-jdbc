package com.thaidev.dao.impl;

import java.util.List;

import com.thaidev.dao.INewsDAO;
import com.thaidev.mapper.NewsMapper;
import com.thaidev.model.NewsModel;
import com.thaidev.paging.Pageable;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {

		String sql = "select * from news where categoryid = ?";
		return query(sql, new NewsMapper(), categoryId);
		
	}

	@Override
	public Long save(NewsModel newsModel) {
		StringBuilder sql = new StringBuilder("insert into news(title, content, ");
		sql.append("categoryid, thumbnail, shortdescription, createddate, createdby) ");
		sql.append("values (?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), newsModel.getTitle(), newsModel.getContent(),
				newsModel.getCategoryId(), newsModel.getThumbnail(), newsModel.getShortDescription(),
				newsModel.getCreatedDate(), newsModel.getCreatedBy());
	}

	@Override
	public NewsModel findOne(Long id) {
		String sql = "select * from news where id = ?";
		List<NewsModel> news = query(sql, new NewsMapper(), id);
		return news.isEmpty()  ? null : news.get(0);
	}

	@Override
	public void update(NewsModel updateNews) {
		StringBuilder sql = new StringBuilder("update news set title = ?, content = ?, ");
		sql.append("thumbnail = ?, shortdescription =  ?, categoryid = ?,");
		sql.append("createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? where id = ?");
		update(sql.toString(), updateNews.getTitle(), updateNews.getContent(), updateNews.getThumbnail(), 
				updateNews.getShortDescription(), updateNews.getCategoryId(), updateNews.getCreatedDate(), 
				updateNews.getCreatedBy(), updateNews.getModifiedDate(), 
				updateNews.getModifiedBy(), updateNews.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "delete from news where id = ?";
		update(sql, id);
	}

	@Override
	public List<NewsModel> findAll(Pageable pageable) {
		StringBuilder sql = new StringBuilder("select * from news ");
		if(pageable.getSorter() != null) {
			sql.append("order by " + pageable.getSorter().getSortName() + " " + pageable.getSorter().getSortBy());
		}
		if(pageable.getOffset() != null && pageable.getLimit() != null) {
			sql.append("limit " + pageable.getOffset() + " " + pageable.getLimit());
		}
		return query(sql.toString(), new NewsMapper());
	
		
	}

	@Override
	public int getTotalItem() {
		String sql = "select count(*) from news";
		return count(sql);
	}
}
