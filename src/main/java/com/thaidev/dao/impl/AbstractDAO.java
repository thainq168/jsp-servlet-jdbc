package com.thaidev.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.thaidev.dao.IGenericDAO;
import com.thaidev.mapper.IRowMapper;

public class AbstractDAO<T> implements IGenericDAO<T> {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jspservletjdbc";
			String user = "root";
			String password = "123456";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@Override
	public List<T> query(String sql, IRowMapper<T> rowMapper, Object...parameters) {
		List<T> results = new ArrayList<>();
		// open connection
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) { 
				return null;
			}
		}
	}

	public void setParameter (PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				// index in statement starts with 1
				int index = i + 1;
				if(parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					statement.setString(index, (String) parameter);
				} else if(parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				} else if(parameter instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) parameter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch(SQLException e) {
			if(connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		ResultSet resultSet = null;
		Long id = null;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if(resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch(SQLException e) {
			if(connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			return null;
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}
}
