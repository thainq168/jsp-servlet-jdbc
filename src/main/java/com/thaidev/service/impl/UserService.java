package com.thaidev.service.impl;

import javax.inject.Inject;

import com.thaidev.dao.IUserDAO;
import com.thaidev.model.UserModel;
import com.thaidev.service.IUserService;

public class UserService implements IUserService {

	@Inject
	private IUserDAO userDao;
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDao.findByUserNameAndPasswordAndStatus(userName, password, status);
	}

}
