package com.masai;

import javax.security.auth.login.LoginException;

import com.masai.LoginDTO;

public interface LoginService {
	public String logIntoAccount(LoginDTO dto) throws LoginException;
	public String logOutFromAccount(String key) throws LoginException;
}
