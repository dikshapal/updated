package com.example.demo.controller;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.RegistrationJDBCTemplate;
import com.example.demo.model.Login;
import com.example.demo.model.Registration;
import com.example.demo.repository.UserRepository;


@CrossOrigin(origins = "http://localhost:4200")

@RestController


public class UserController {
	

//	@GetMapping
//	public String check() {
//		return "welcome to app";
//		
//	}
//	
//	@GetMapping(path="/getusernames")
//public List<String> getAllUserNames(){
//	return userRepository.getAllUserNames();
//	
//}
	
	 ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	 
	 
	 @Autowired
	 UserRepository userRepository;
	
	 
	 
	 RegistrationJDBCTemplate registrationJDBCTemplate = 
	         (RegistrationJDBCTemplate)context.getBean("registrationJDBCTemplate");
	
	List<Registration> r = registrationJDBCTemplate.list();
	
	@RequestMapping(path="/register")
	@GetMapping(produces = "application/json")
	public List<Registration> getStatus(){
		return r;
	}
	
//	     public Registration create(@RequestBody Registration registration) {
//		  
//		  System.out.println("hi");
//	       userRepository.addUser(registration);
//	        //System.out.println(userId);
//	       return registration;
//	        
//	     }
	
	
	 //@RequestMapping
    @PostMapping({ "/login" })
     public boolean Login(@RequestBody Login login) {
    	
    	System.out.println("1");
      boolean result  =    userRepository.login(login);
      System.out.println(result);
          return result;  
    }
	 
	 
//	    @RequestMapping
//         @PostMapping({ "/login" })
//         public boolean login(@RequestBody Login login) {
//		boolean result=    userRepository.login(login);
//          System.out.println(result);
//         return result;  
//    }
   }

    
