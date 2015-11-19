package com.myenergy.dashboard.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myenergy.dashboard.Utils.MyEnergyConstants;
import com.myenergy.dashboard.core.model.ProcessEntity;
import com.myenergy.dashboard.core.service.DashboardService;

@Controller
public class MyEnergyController {
	
	static Logger logger = Logger.getLogger(MyEnergyConstants.LOGGER);
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	@Autowired
	private DashboardService dashboardService;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
	
 
	// Default Redirection to Home Page
	@RequestMapping("/redirectHome")
	public String redirectHome(Map<String, Object> map){
		
		String redirectPage = "/dashboard/Homepage";
		ProcessEntity loadDetails = new ProcessEntity();

		try {
		String dateStr = "2015-10-29 00:00:00";
		Date fetchDate;
		fetchDate = sdf.parse(dateStr);
		
		
		List<ProcessEntity> processEntityList=dashboardService.fetchDailyLoadStatus(fetchDate);
		map.put("processEntityList", processEntityList);
		map.put("loadDetails",loadDetails);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return redirectPage;
	}
	

	// Redirecting to FeedbackPage
	@RequestMapping(value="/getLoadDetails")
	public String getLoadDetails(Map<String, Object> map, HttpSession session){
		String redirectPage = "/dashboard/Homepage";
		ProcessEntity loadDetails = (ProcessEntity) session.getAttribute("loadDetails");
		System.out.println("The Date input :"+loadDetails.getFiledate());
		
		List<ProcessEntity> processEntityList=dashboardService.fetchDailyLoadStatus(loadDetails.getFiledate());
		map.put("processEntityList", processEntityList);
		map.put("loadDetails",loadDetails);
		return redirectPage;
	}
	
}