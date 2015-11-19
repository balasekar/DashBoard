package com.myenergy.dashboard.core.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myenergy.dashboard.core.dao.DashBoardDAO;
import com.myenergy.dashboard.core.model.ProcessEntity;

@Service
public class DashboardServiceImpl implements DashboardService{
	@Autowired
	private DashBoardDAO dashboardDAO;

	@Transactional("postgresTransactionManager") 
	public List<ProcessEntity> fetchDailyLoadStatus(Date fetchDate) {
		List<ProcessEntity> processEntityList = dashboardDAO.fetchDailyLoadStatusDAO(fetchDate);
		return processEntityList;
	}
	
}