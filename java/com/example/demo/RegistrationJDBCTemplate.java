package com.example.demo;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.model.Registration;

public class RegistrationJDBCTemplate {
	private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   
	   @Bean
	   public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	       return new JdbcTemplate(dataSource);
	   }
	

	   public List<Registration> list() {
		   String SQL = "select * from Registration where email=?";
		   String email="somanti";
		      List<Registration> cs = jdbcTemplateObject.query(SQL, new RegistrationMapper(),email);
		      return cs ;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

}
