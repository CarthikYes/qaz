package com.masai.service;

import javax.security.auth.login.LoginException;

import com.masai.entities.LoginDTO;

public interface LoginService {
	public String logIntoAccount(LoginDTO dto) throws LoginException;
	public String logOutFromAccount(String key) throws LoginException;
}
