package com.myenergy.dashboard.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;

import com.myenergy.dashboard.type.JodaTimeDurationType;
@Entity
@IdClass(ProcessEntityPK.class)
@Table(name="audit.process_entity")
@TypeDef(name="interval", typeClass = JodaTimeDurationType.class)
public class ProcessEntity implements Serializable{
	@Id
	 String entity;
	 String processname;
	 BigDecimal status;
	 BigDecimal sourcecount;
	 BigDecimal insertcount;
	 BigDecimal updatecount;
	 BigDecimal deletecount;
	 BigDecimal errorcount;
	 BigDecimal targetcount;
	@Id
	@Temporal(TemporalType.TIMESTAMP)
	 Date starttime;
	@Temporal(TemporalType.TIMESTAMP)
	 Date endtime;
	@Type(type = "interval") 
	 Integer runtime;
	 String filename;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	 Date filedate;
	 String failurereason;
	 BigDecimal fileseqnum;
	 
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public String getProcessname() {
		return processname;
	}
	public void setProcessname(String processname) {
		this.processname = processname;
	}
	public BigDecimal getStatus() {
		return status;
	}
	public void setStatus(BigDecimal status) {
		this.status = status;
	}
	public BigDecimal getSourcecount() {
		return sourcecount;
	}
	public void setSourcecount(BigDecimal sourcecount) {
		this.sourcecount = sourcecount;
	}
	public BigDecimal getInsertcount() {
		return insertcount;
	}
	public void setInsertcount(BigDecimal insertcount) {
		this.insertcount = insertcount;
	}
	public BigDecimal getUpdatecount() {
		return updatecount;
	}
	public void setUpdatecount(BigDecimal updatecount) {
		this.updatecount = updatecount;
	}
	public BigDecimal getDeletecount() {
		return deletecount;
	}
	public void setDeletecount(BigDecimal deletecount) {
		this.deletecount = deletecount;
	}
	public BigDecimal getErrorcount() {
		return errorcount;
	}
	public void setErrorcount(BigDecimal errorcount) {
		this.errorcount = errorcount;
	}
	public BigDecimal getTargetcount() {
		return targetcount;
	}
	public void setTargetcount(BigDecimal targetcount) {
		this.targetcount = targetcount;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public Integer getRuntime() {
		return runtime;
	}
	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Date getFiledate() {
		return filedate;
	}
	public void setFiledate(Date filedate) {
		this.filedate = filedate;
	}
	public String getFailurereason() {
		return failurereason;
	}
	public void setFailurereason(String failurereason) {
		this.failurereason = failurereason;
	}
	public BigDecimal getFileseqnum() {
		return fileseqnum;
	}
	public void setFileseqnum(BigDecimal fileseqnum) {
		this.fileseqnum = fileseqnum;
	}
	@Override
	public String toString() {
		return "ProcessEntity [entity=" + entity + ", processname=" + processname + ", status=" + status
				+ ", sourcecount=" + sourcecount + ", insertcount=" + insertcount + ", updatecount=" + updatecount
				+ ", deletecount=" + deletecount + ", errorcount=" + errorcount + ", targetcount=" + targetcount
				+ ", starttime=" + starttime + ", endtime=" + endtime + ", runtime=" + runtime + ", filename="
				+ filename + ", filedate=" + filedate + ", failurereason=" + failurereason + ", fileseqnum="
				+ fileseqnum + "]";
	}

	 
}
