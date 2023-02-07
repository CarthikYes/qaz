package com.masai.service;

import javax.security.auth.login.LoginException;

import com.masai.entities.AdminDto;

public interface AdminLoginService {
	public String logIntoAccount(AdminDto dto) throws LoginException;
	public String logOutFromAccount(String key) throws LoginException;
}
