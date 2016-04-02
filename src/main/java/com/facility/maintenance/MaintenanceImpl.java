package com.facility.maintenance;


public class MaintenanceImpl implements Maintenance {
	
	private int facilityID;
	private String details;
	private int cost;
	
	public MaintenanceImpl() {}
	
	public int getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(int facilityID) {
		this.facilityID = facilityID;
	}

	public String getDetails() {
		return details;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
