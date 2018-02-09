/**
 * 
 */
package com.riverbed.jsconapi.beans;

import java.io.Serializable;

/**
 * This objects represents the OSPF configuration for a SteelConnect zone.
 * @author rjourdan <a href="mailto:romain.jourdan@gmail.com">romain.jourdan@gmail.com</a>
 * @version 1.0
 */
public class SconOSPF implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2005914399626955849L;
	private String OSPFNetworkName;
	private String password;
	private int area;
	private boolean inherit;
	private int hello_interval;
	private int dead_interval;
	private int priority;
	private int cost;
		
	
	/**
	 * @return the oSPFNetworkName
	 */
	public String getOSPFNetworkName() {
		return OSPFNetworkName;
	}
	/**
	 * @param oSPFNetworkName the oSPFNetworkName to set
	 */
	public void setOSPFNetworkName(String oSPFNetworkName) {
		OSPFNetworkName = oSPFNetworkName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the area
	 */
	public int getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(int area) {
		this.area = area;
	}
	/**
	 * @return the inherit
	 */
	public boolean isInherit() {
		return inherit;
	}
	/**
	 * @param inherit the inherit to set
	 */
	public void setInherit(boolean inherit) {
		this.inherit = inherit;
	}
	/**
	 * @return the hello_interval
	 */
	public int getHello_interval() {
		return hello_interval;
	}
	/**
	 * @param hello_interval the hello_interval to set
	 */
	public void setHello_interval(int hello_interval) {
		this.hello_interval = hello_interval;
	}
	/**
	 * @return the dead_interval
	 */
	public int getDead_interval() {
		return dead_interval;
	}
	/**
	 * @param dead_interval the dead_interval to set
	 */
	public void setDead_interval(int dead_interval) {
		this.dead_interval = dead_interval;
	}
	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}
	/**
	 * @param oSPFNetworkName
	 * @param password
	 * @param area
	 * @param inherit
	 * @param hello_interval
	 * @param dead_interval
	 * @param priority
	 * @param cost
	 */
	public SconOSPF(String oSPFNetworkName, String password, int area, boolean inherit, int hello_interval,
			int dead_interval, int priority, int cost) {
		super();
		this.OSPFNetworkName = oSPFNetworkName;
		this.password = password;
		this.area = area;
		this.inherit = inherit;
		this.hello_interval = hello_interval;
		this.dead_interval = dead_interval;
		this.priority = priority;
		this.cost = cost;
	}
	/**
	 * @param password
	 * @param area
	 * @param inherit
	 * @param hello_interval
	 * @param dead_interval
	 * @param priority
	 * @param cost
	 */
	public SconOSPF(String password, int area, boolean inherit, int hello_interval, int dead_interval, int priority,
			int cost) {
		super();
		this.password = password;
		this.area = area;
		this.inherit = inherit;
		this.hello_interval = hello_interval;
		this.dead_interval = dead_interval;
		this.priority = priority;
		this.cost = cost;
	}
	
	public SconOSPF() {
		super();
		this.OSPFNetworkName = "";
		this.password = "";
		this.area = 0;
		this.inherit = Boolean.FALSE;
		this.hello_interval = 10;
		this.dead_interval = 40;
		this.priority = 1;
		this.cost = 10;
	}
	
	
	


}
