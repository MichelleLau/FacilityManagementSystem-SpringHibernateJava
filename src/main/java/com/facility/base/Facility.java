/**
 * 
 */
package com.facility.base;

/**
 * @author Chrissy
 *
 */
public interface Facility {
	public FacilityDetail getFacilityDetail();
	public void setFacilityDetail(FacilityDetail facilityDetail);
	public void setFacilityID(int facilityID);
	public int getFacilityID();
}
