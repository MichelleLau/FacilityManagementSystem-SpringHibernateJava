package com.facility.use;

import java.time.LocalDate;

import com.facility.base.Facility;

public class FacilityUseImpl implements FacilityUse {
	
	private int facilityID;
	private int roomNumber;
	private LocalDate startDate;
	private LocalDate endDate;

	public FacilityUseImpl() {}
	
	public int getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(int facilityID) {
		this.facilityID = facilityID;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

}
