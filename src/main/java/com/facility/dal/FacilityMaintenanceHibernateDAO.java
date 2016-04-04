package com.facility.dal;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.facility.base.Facility;
import com.facility.maintenance.*;

public class FacilityMaintenanceHibernateDAO {
	public Maintenance makeFacilityMaintRequest(Facility fac, String maintenanceDetails, int cost) {
		
		Maintenance maint = new MaintenanceImpl();
		maint.setFacility(fac);
		maint.setFacilityID(fac.getFacilityID());
		maint.setDetails(maintenanceDetails);
		maint.setCost(cost);
		
		System.out.println("*************** Adding maintenance request to DB with ID ...  " + fac.getFacilityID());
		Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save("maint_request", maint);
		session.getTransaction().commit();
		
		return maint;
	}
	
}
