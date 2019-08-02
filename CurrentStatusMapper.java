package com.impetus.casestudy;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.impetus.casestudy.model.CurrentStatus;

public class CurrentStatusMapper implements RowMapper<CurrentStatus> {
	@Override
	public CurrentStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
		CurrentStatus cs = new CurrentStatus();
		cs.setAccountId(rs.getInt("accountId"));
		cs.setAmountremaining(rs.getInt("amountremaining"));
		cs.setAmountSanction(rs.getInt("amountSanction"));
	
		return cs;
	}

}
