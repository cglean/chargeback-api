package com.example.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usage implements Serializable{

	@Id
	private long id;
	
	private double cpu;
	private long memory;
	private long disk;
	private Date time;
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
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
	@Override
	public String toString() {
		return "Usage [id=" + id + ", cpu=" + cpu + ", memory=" + memory + ", disk=" + disk + ", time=" + time
				+ ", orgName=" + orgName + ", appname=" + appname + ", spaceName=" + spaceName + ", instanceIndex="
				+ instanceIndex + "]";
	}
	
	
}
