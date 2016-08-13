package com.example.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="usage_stat")
public class Usage {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long usageId;
	
	private double cpu;
	private long memory;
	private long disk;
	private Timestamp createdTime;
	private String orgName;
	private String appname;
	private String spaceName;
	private int instanceIndex;
	
	
	public long getUsageId() {
		return usageId;
	}


	public void setUsageId(long usageId) {
		this.usageId = usageId;
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


	public Timestamp getCreatedTime() {
		return createdTime;
	}


	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
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


	@Override
	public String toString() {
		return "Usage [id=" + usageId + ", cpu=" + cpu + ", memory=" + memory + ", disk=" + disk + ", time=" + createdTime
				+ ", orgName=" + orgName + ", appname=" + appname + ", spaceName=" + spaceName + ", instanceIndex="
				+ instanceIndex + "]";
	}
	@PrePersist	
	public void populateCreatedDate(){
		createdTime = new Timestamp(new Date().getTime());
	}
}
