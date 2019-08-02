package com.impetus.casestudy;

import java.util.List;

import javax.sql.DataSource;

import com.impetus.casestudy.model.CurrentStatus;

public interface CurrentStatusDao {
	public void setDataSource(DataSource ds);

	   public List<CurrentStatus> list(); 
}
