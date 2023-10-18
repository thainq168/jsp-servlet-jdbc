package com.thaidev.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.thaidev.model.RoleModel;
import com.thaidev.model.UserModel;

public class UserMapper implements IRowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		try {
			UserModel users = new UserModel();
			users.setId(resultSet.getLong("id"));
			users.setUserName(resultSet.getString("username"));
			users.setPassword(resultSet.getString("password"));
			users.setFullName(resultSet.getString("fullname"));
			users.setStatus(resultSet.getInt("status"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				users.setRole(role);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return users;
		} catch (SQLException e) {
			return null;
		}
	}
	
}
