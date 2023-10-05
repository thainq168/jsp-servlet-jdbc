package com.thaidev.dao;

import java.util.List;

import com.thaidev.mapper.IRowMapper;

public interface IGenericDAO<T> {
	List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters);
	void update(String sql, Object...parameters);
	Long insert(String sql, Object...parameters);
}
