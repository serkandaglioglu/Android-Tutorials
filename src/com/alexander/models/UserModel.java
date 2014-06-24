package com.alexander.models;

public class UserModel
{
	public Integer UserId;
	public String FullName;
	public String Avatar;
	public String About;
	
	public UserModel(Integer userId, String fullName, String avatar ,String about )
	{
		this.UserId = userId;
		this.FullName = fullName;
		this.Avatar = avatar;
		this.About = about;
	}
}
