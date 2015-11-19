package com.myenergy.dashboard.core.service;

import java.util.Date;
import java.util.List;

import com.myenergy.dashboard.core.model.ProcessEntity;

public interface DashboardService {
	public List<ProcessEntity> fetchDailyLoadStatus (Date fetchDate);
}