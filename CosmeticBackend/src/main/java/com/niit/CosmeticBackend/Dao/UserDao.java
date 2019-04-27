package com.niit.CosmeticBackend.Dao;

import java.util.List;

import com.niit.CosmeticBackend.Model.User;

public interface UserDao {

	public boolean saveorupdate(User user);
	public boolean delete(User user);
	public User  getUser(String uId);
	public List<User> getUList();
	public User isValid(String umail, String pwd);
	public User getEmail(String curusername);
	
}
