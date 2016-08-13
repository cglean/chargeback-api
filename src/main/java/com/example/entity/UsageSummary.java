package com.example.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UsageSummary {

	@Id
	@GeneratedValue
	private long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp fromDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp toDate;
	private double cpu;
	private long memory;
	private long disk;
	private Timestamp time;
	private String orgName;
	private String appname;
	private String spaceName;
	private int instanceIndex;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Timestamp getFromDate() {
		return fromDate;
	}
	public void setFromDate(Timestamp fromDate) {
		this.fromDate = fromDate;
	}
	public Timestamp getToDate() {
		return toDate;
	}
	public void setToDate(Timestamp toDate) {
		this.toDate = toDate;
	}
	public double getCpu() {
		return cpu;
	}
	public void setCpu(double cpu) {
		this.cpu = cpu;
	}
	public long getMemory() {
		return memory;
	}
	public void setMemory(long memory) {
		this.memory = memory;
	}
	public long getDisk() {
		return disk;
	}
	public void setDisk(long disk) {
		this.disk = disk;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getAppname() {
		return appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}
	public String getSpaceName() {
		return spaceName;
	}
	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}
	public int getInstanceIndex() {
		return instanceIndex;
	}
	public void setInstanceIndex(int instanceIndex) {
		this.instanceIndex = instanceIndex;
	}
	
	
	
}
