package com.myenergy.dashboard.core.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myenergy.dashboard.Utils.MyEnergyConstants;
import com.myenergy.dashboard.core.model.ProcessEntity;

@Repository
public class DashBoardDAOImpl implements DashBoardDAO{
	
	static Logger logger = Logger.getLogger(MyEnergyConstants.LOGGER);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<ProcessEntity> fetchDailyLoadStatusDAO (Date fetchDate){
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(ProcessEntity.class);
		cr.add(Restrictions.eq("filedate", fetchDate));
		return cr.list();
	}

}
