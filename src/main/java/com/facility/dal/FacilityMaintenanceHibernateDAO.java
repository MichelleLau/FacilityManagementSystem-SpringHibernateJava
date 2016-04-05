package com.facility.dal;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.facility.base.Facility;
import com.facility.maintenance.*;

public class FacilityMaintenanceHibernateDAO {
	
	/***
	 * Creates a new maintenance request and inserts it into the maint_request table.
	 * @param fac Facility where the maintenance request is made
	 * @param maintenanceDetails description of the maintenance requested
	 * @param cost of maintenance
	 * @return the Maintenance object that was requested
	 */
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
	
	/***
	 * Schedules a maintenance request by first adding it to the maintenance table.
	 * @param maintRequest the request to be scheduled
	 */
	public void scheduleMaintenanceAdd(Maintenance maintRequest) {
		System.out.println("*************** Adding maintenance to DB with ID ...  " + maintRequest.getFacilityID());
		Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save("maintenance", maintRequest);
		session.getTransaction().commit();
	}
	
	/***
	 * Second step of scheduling maintenance - removing maintenance request from the maint_request table.
	 * @param maintRequest the request to be scheduled
	 */
	public void scheduleMaintenanceDelete(Maintenance maintRequest) {
		System.out.println("*************** Removing maintenance request from DB with ID ...  " + maintRequest.getFacilityID());
		Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete("maint_request", maintRequest);
		session.getTransaction().commit();
	}
	
	/***
	 * Lists Maintenance objects from the maint_request table that have yet to be 
	 * scheduled/completed at a particular facility.
	 * @param fac Facility to list maintenance requests for
	 * @return a list of Maintenance objects containing maintenance requests
	 */
	@SuppressWarnings("unchecked")
	public List<Maintenance> listMaintRequests(Facility fac) {
		try {
			System.out.println("*************** Retrieving a list of maintenance requests for Facility ...  " + fac.getFacilityID());
			Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			//System.out.println("*************** Hibernate session is created ..................\n" + session.toString());
			
			Query getMaintRequestsQuery = session.createQuery("From maint_request where facility_ID =" + fac.getFacilityID());		
			
			System.out.println("*************** Retrieve Query is ....>>\n" + getMaintRequestsQuery.toString()); 
			
			List<Maintenance> maintRequests = getMaintRequestsQuery.list();
			session.getTransaction().commit();
			
			return maintRequests;
		} catch (Exception e) {
			System.err.println("UseHibernateDAO: Threw an Exception retreiving "
			   		+ "list of maintenance requests.");
			   System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	/***
	 * Lists Maintenance objects from the maintenance table that have already been
	 * completed at a particular facility.
	 * @param fac Facility to list maintenance for
	 * @return a list of Maintenance objects containing completed maintenance
	 */
	@SuppressWarnings("unchecked")
	public List<Maintenance> listMaintenance(Facility fac) {
		try {
			System.out.println("*************** Retrieving a list of maintenance requests for Facility ...  " + fac.getFacilityID());
			Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			//System.out.println("*************** Hibernate session is created ..................\n" + session.toString());
			
			Query getMaintRequestsQuery = session.createQuery("From maintenance where facility_ID =" + fac.getFacilityID());		
			
			System.out.println("*************** Retrieve Query is ....>>\n" + getMaintRequestsQuery.toString()); 
			
			List<Maintenance> maintRequests = getMaintRequestsQuery.list();
			session.getTransaction().commit();
			
			return maintRequests;
		} catch (Exception e) {
			System.err.println("UseHibernateDAO: Threw an Exception retreiving "
			   		+ "list of maintenance.");
			   System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	/***
	 * Calculates the sum of completed maintenance at a particular facility from the maintenance table.
	 * @param fac Facility to calculate maintenance cost
	 * @return total cost of completed maintenance
	 */
	@SuppressWarnings("unchecked")
	public int calcMaintenanceCostForFacility(Facility fac) {
		try {
			System.out.println("*************** Calculating maintenance cost for Facility ...  " + fac.getFacilityID());
			Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			//System.out.println("*************** Hibernate session is created ..................\n" + session.toString());
			
			Query calcMaintCostQuery = session.createQuery("select sum(cost) as int from maintenance where facility_ID =" + fac.getFacilityID());		
			
			System.out.println("*************** Retrieve Query is ....>>\n" + calcMaintCostQuery.toString()); 
			
			List<Long> cost = calcMaintCostQuery.list();
			session.getTransaction().commit();
			return cost.get(0).intValue();
		} catch (Exception e) {
			System.err.println("UseHibernateDAO: Threw an Exception calculating "
			   		+ "cost of maintenance.");
			   System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}
	
	/***
	 * Removes maintenance from maintenance table.
	 * @param maintenance to be removed
	 */
	public void removeMaintenance(Maintenance maintenance) {
		System.out.println("*************** Removing maintenance request from DB with ID ...  " + maintenance.getFacilityID());
		Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete("maintenance", maintenance);
		session.getTransaction().commit();
	}
}
