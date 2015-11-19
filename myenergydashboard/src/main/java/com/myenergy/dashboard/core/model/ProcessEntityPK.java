package com.myenergy.dashboard.core.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
public class ProcessEntityPK implements Serializable{
	
	public String entity;
	@Temporal(TemporalType.TIMESTAMP)
	public Date starttime;
	
	public ProcessEntityPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProcessEntityPK(String entity, Date starttime) {
		super();
		this.entity = entity;
		this.starttime = starttime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entity == null) ? 0 : entity.hashCode());
		result = prime * result + ((starttime == null) ? 0 : starttime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProcessEntityPK other = (ProcessEntityPK) obj;
		if (entity == null) {
			if (other.entity != null)
				return false;
		} else if (!entity.equals(other.entity))
			return false;
		if (starttime == null) {
			if (other.starttime != null)
				return false;
		} else if (!starttime.equals(other.starttime))
			return false;
		return true;
	}
	
	

}
