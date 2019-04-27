package com.niit.CosmeticBackend.Dao;

import java.util.List;

import com.niit.CosmeticBackend.Model.Authentication;

public interface AuthenticationDao {
	
	public boolean saveorupdate(Authentication authentiaction);
	public boolean delete(Authentication authentication);
	public Authentication getAuthentication(String roleId);
	public List<Authentication> authenticationList();

}
