package com.impetus.casestudy;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.impetus.casestudy.model.CurrentStatus;

public class CurrentStatusJDBCTemplate {
	private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	

	   public List<CurrentStatus> list() {
		   String SQL = "select * from CurrentStatus where accountId=?";
		   int aid=102;
		      List<CurrentStatus> cs = jdbcTemplateObject.query(SQL, new CurrentStatusMapper(),aid);
		      return cs ;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}
}
