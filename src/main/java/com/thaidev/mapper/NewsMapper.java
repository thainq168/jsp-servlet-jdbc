package com.thaidev.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.thaidev.model.NewsModel;

public class NewsMapper implements IRowMapper<NewsModel> {

	@Override
	public NewsModel mapRow(ResultSet resultSet) {
		try {
			NewsModel news = new NewsModel();
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setContent(resultSet.getString("content"));
			news.setCategoryId(resultSet.getLong("categoryid"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setShortDescription(resultSet.getString("shortdescription"));
			news.setCreatedBy(resultSet.getString("createdby"));
			news.setCreatedDate(resultSet.getTimestamp("createddate"));
			if(resultSet.getTimestamp("modifieddate") != null) {
				news.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if(resultSet.getTimestamp("modifiedby") != null) {
				news.setModifiedDate(resultSet.getTimestamp("modifiedby"));
			}
			return news;
		} catch (SQLException e) {
			return null;
		}
	}
	
}
