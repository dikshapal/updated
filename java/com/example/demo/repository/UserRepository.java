package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Login;
import com.example.demo.model.Registration;

@Repository
public class UserRepository {
	

	   
	
public JdbcTemplate jdbcTemplate;
	
	 List<Map<String,Object>> obj=new ArrayList<>();

	private DataSource dataSource;
	 
		public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
		      this.jdbcTemplate = new JdbcTemplate(dataSource);
			
		}
	 
	
	   public void addUser(Registration registration)
	    { System.out.println("hi");
	        String email= registration.getEmail();
	        jdbcTemplate.update("insert into Registration (firstname,lastname,email,password,address,Contact)values(?,?,?,?,?,?)",registration.getFirstname(),registration.getLastname(),registration.getEmail(),registration.getPassword(),registration.getAddress(),registration.getContact());
	        //int userId =jdbcTemplate.queryForObject("select userId from  registration where email=?",Integer.class,email);
	       
	    }
	
	public List<String> getAllUserNames(){
		List<String> usernameList= new ArrayList<>();
	
	
		usernameList.addAll(jdbcTemplate.queryForList("select firstname from Registration;",String.class));
		
		return usernameList;
		}
	
	 public boolean login(Login login) {
//	        String em= login.getEmail();
//	        String pass= login.getPassword();
//	        
//	        String sql="select email, password from Registration where email = ? AND password= ?";
//	        //jdbcTemplate.update("select emailId, password from registration where emailId=? AND password=?",user.getEmail(),user.getPassword());
//	        obj=jdbcTemplate.queryForList(sql,em,pass);
//	        System.out.println(obj);
		 
		
	        try {
	        	 String e1 = login.getEmail();
	 	        String password = login.getPassword();
	 	        
	 	        //String e = "somanti";
	 	        
	 	        System.out.println("2");

	        	System.out.println("3");
	        	System.out.println(password);
	        	
	        	String sql="select password from Registration where email=?";
	        	String checkPassword = jdbcTemplate.queryForObject(sql,  String.class, e1);
	        	
	        	   System.out.println("4");
	            String checkUserName = jdbcTemplate.queryForObject(
	                    "select email from Registration where password = ?", String.class, password);
	            
	            
	         

	            

	            if ((checkUserName.equals(e1)) && (checkPassword.equals(password))) {
	                return true;
	            }
	        } catch (EmptyResultDataAccessException e) {

	        }
	        return false;

	    
	    
		 
		 
	 }
	    
    }


