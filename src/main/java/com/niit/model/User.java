package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User 
{
	@Id
	private String username;
	
	private String password;
	private String custName;
	private String role;
	private String mobile;
	private String usernickname;
	
	public String getUsernickname() {
		return usernickname;
	}
	public void setUsernickname(String usernickname) {
		this.usernickname = usernickname;
	}
	public String getMobile() {
		return mobile;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String mobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
}
