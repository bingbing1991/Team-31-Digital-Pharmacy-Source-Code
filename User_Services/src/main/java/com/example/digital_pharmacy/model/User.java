package com.example.digital_pharmacy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user_account")
public class User
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
//    @SequenceGenerator(sequenceName = "user_seq", allocationSize = 1, name = "USER_SEQ")
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	public int getUserId()
	{
		return userId;
	}
	
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	
	public String getEmailId()
	{
		return emailId;
	}
	
	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public User(int userId, String emailId, String userName, String password)
	{
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
	}
	
	public User()
	{
		
	}
	
}
