package com.facility.base;

/**
 * @author Chrissy
 *
 */
public class FacilityImpl implements Facility {
	
	private int facilityID;
	private FacilityDetail detailsAboutFacility;
		
	public FacilityImpl() {}
	
	public FacilityDetail getDetailsAboutFacility() {
		return detailsAboutFacility;
	}

	public void setDetailsAboutFacility(FacilityDetail detailsAboutFacility) {
		this.detailsAboutFacility = detailsAboutFacility;
	}

	public void setFacilityID(int facilityID) {
		this.facilityID = facilityID;
	}

	public int getFacilityID() {
		return facilityID;
	}

	
}
