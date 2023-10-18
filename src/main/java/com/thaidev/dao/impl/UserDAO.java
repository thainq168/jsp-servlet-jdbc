package com.thaidev.dao.impl;

import java.util.List;

import com.thaidev.dao.IUserDAO;
import com.thaidev.mapper.UserMapper;
import com.thaidev.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO{

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		StringBuilder sql = new StringBuilder("select * from user inner join role on user.roleid = role.id");
		sql.append(" where username = ? and password = ? and status = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password, status);
		return users.isEmpty()  ? null : users.get(0);
	}

}
