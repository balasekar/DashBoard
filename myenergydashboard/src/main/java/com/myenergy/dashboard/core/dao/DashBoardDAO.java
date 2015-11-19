package com.myenergy.dashboard.core.dao;

import java.util.Date;
import java.util.List;

import com.myenergy.dashboard.core.model.ProcessEntity;

public interface DashBoardDAO {
	
	public List<ProcessEntity> fetchDailyLoadStatusDAO (Date fetchDate);

}
