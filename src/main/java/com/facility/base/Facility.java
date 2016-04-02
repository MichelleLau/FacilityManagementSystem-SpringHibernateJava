/**
 * 
 */
package com.facility.base;

/**
 * @author Chrissy
 *
 */
public interface Facility {
	public FacilityDetail getDetailsAboutFacility();
	public void setDetailsAboutFacility(FacilityDetail detailsAboutFacility);
	public void setFacilityID(int facilityID);
	public int getFacilityID();
}
