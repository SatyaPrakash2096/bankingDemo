package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig(){
		
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception message is: " +e.getMessage());
		}
	}
	
	public String getApplicationUrl() {
		String  url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() {
		String  username = pro.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		String  password = pro.getProperty("password");
		return password;
	}
	
	public String getName() {
		String  name = pro.getProperty("name");
		return name;
	}
	
	public String getChromePath() {
		String  chromePath = pro.getProperty("chromePath");
		return chromePath;
	}
	
	public String getIEPath() {
		String  IEPath = pro.getProperty("IEPath");
		return IEPath;
	}
}
