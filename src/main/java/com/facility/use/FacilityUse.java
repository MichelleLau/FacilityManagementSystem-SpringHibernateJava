package com.facility.use;

import java.time.LocalDate;

public interface FacilityUse {
	public int getFacilityID();
	public void setFacilityID(int facilityID);
	public int getRoomNumber();
	public void setRoomNumber(int roomNumber);
	public LocalDate getStartDate();
	public void setStartDate(LocalDate startDate);
	public LocalDate getEndDate();
	public void setEndDate(LocalDate endDate);
}
