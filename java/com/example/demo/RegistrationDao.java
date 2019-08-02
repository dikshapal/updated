package com.example.demo;

import java.util.List;

import javax.sql.DataSource;

import com.example.demo.model.Registration;

public interface RegistrationDao {
	public void setDataSource(DataSource ds);

	   public List<Registration> list(); 
}


