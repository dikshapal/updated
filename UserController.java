package com.impetus.casestudy;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.casestudy.model.CurrentStatus;
import com.impetus.casestudy.model.FinancialCondition;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/getstatus"})
public class UserController {

	 ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	 
	//FinancialCondition
			FinancialConditionJDBCTemplate financialConditionJDBCTemplate = 
			         (FinancialConditionJDBCTemplate)context.getBean("financialConditionJDBCTemplate");
			List<FinancialCondition> fc = financialConditionJDBCTemplate.list();
		      
	//CurrentStatus		
			CurrentStatusJDBCTemplate currentStatusJDBCTemplate = 
			         (CurrentStatusJDBCTemplate)context.getBean("currentStatusJDBCTemplate");
			List<CurrentStatus> cs = currentStatusJDBCTemplate.list();
			
			
			@GetMapping(produces = "application/json")
			public List<CurrentStatus> getStatus(){
				return cs;
			}
			

}
