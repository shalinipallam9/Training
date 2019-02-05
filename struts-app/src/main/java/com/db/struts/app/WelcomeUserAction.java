package com.db.struts.app;

public class WelcomeUserAction{
	
	
	public String execute() throws Exception {
		if("sri".equals(getUsername()) && "sai".equals(getPassword()))
		return "SUCCESS";
		else return "ERROR";
	}

	private String username;
	
	private String password;
	 
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	// all struts logic here
	/*public String execute() {

		return "SUCCESS";

	}*/

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}