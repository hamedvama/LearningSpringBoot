package com.omp.transport.printertools.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {
	
	private String base;
	private String url;
	private String username;
	private String pwd;	
	private FileInputStream fileProperties ;
	/**
	 * @throws FileNotFoundException 
	 * 
	 */
	public ConnectionDB() throws FileNotFoundException {

		this.fileProperties = new FileInputStream("src\\main\\resources\\application.properties");
	}
	
	/**
	 * @param base
	 */
	public ConnectionDB(String base) {
		this.base = base;
	}



	/**
	 * @param base
	 * @param url
	 * @param username
	 * @param pwd
	 * @throws FileNotFoundException 
	 */
	public ConnectionDB(String base, String url, String username, String pwd) throws FileNotFoundException {
		super();
		this.base = base;
		this.url = url;
		this.username = username;
		this.pwd = pwd;
		this.fileProperties = new FileInputStream("src\\main\\resources\\application.properties");
	}
	
	public Connection getconnection() throws SQLException, IOException {
		// load the properties file
        Properties pros = new Properties();
        pros.load(fileProperties);
        url = pros.getProperty("spring.datasource.url");
        username = pros.getProperty("spring.datasource.username");
        pwd = pros.getProperty("spring.datasource.password");
		return DriverManager.getConnection(url, username, pwd);
	}
	
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
