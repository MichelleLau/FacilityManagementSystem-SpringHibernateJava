package com.facility.dal;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.facility.base.*;

public class FacilityHibernateDAO {
	
	
	/***
	 * Returns detail information about a facility, including its name, facility ID, number of rooms, 
	 * and a phone number if it's listed.
	 * @param facilityID of facility
	 * @return facility detail information
	 */
	@SuppressWarnings("rawtypes")
	public FacilityDetail getFacilityInformation(int facilityID) {
		try {
			System.out.println("*************** Searching for facility information with ID ...  " + facilityID);
			Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			//System.out.println("*************** Hibernate session is created ..................\n" + session.toString());
			
			Query getFacilityQuery = session.createQuery("From FacilityDetailImpl where facilityID =" + facilityID);
			
			System.out.println("*************** Retrieve Query is ....>>\n" + getFacilityQuery.toString()); 
			
			List facilityDetail = getFacilityQuery.list();
			System.out.println("Getting Facility Details using HQL. \n");
	
			session.getTransaction().commit();
			return (FacilityDetail)facilityDetail.get(0);
		} catch (Exception e) {
			System.err.println("FacilityHibernateDAO: Threw an Exception retreiving "
			   		+ "facility information.");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	/***
	 * Add a new facility to the facility table and details about the facility to facility_detail table.
	 * Must create a new facility object before running addNewFacility method.
	 * @param fac Facility object to be added to the database
	 */
	public void addNewFacility(Facility fac) {
		System.out.println("*************** Adding facility to DB with ID ...  " + fac.getFacilityID());
		Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(fac);
		session.getTransaction().commit();
	}

	/***
	 * Adds optional detail information (phone number) about the facility
	 * @param ID facility ID
	 * @param phoneNumber number to be added
	 */
	public void addFacilityDetail(int ID, int phoneNumber) {
		try {
			System.out.println("*************** Adding facility details to Facility  " + ID);
			Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			FacilityDetail facilityDetail = (FacilityDetail) session.get(FacilityDetailImpl.class, ID);
			facilityDetail.setPhoneNumber(phoneNumber);
			session.update(facilityDetail);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("FacilityHibernateDAO: Threw an Exception updating "
			   		+ "facility detail.");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/***
	 * Removes facility from the facility and facility_detail tables.
	 * @param fac facility to be removed
	 */
	public void removeFacility(Facility fac) {
		//removes from facility and facility_detail tables
		System.out.println("*************** Deleting facility from DB with ID ...  " + fac.getFacilityID());
		Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(fac);
		session.getTransaction().commit();
	}
	
	/***
	 * Removes facility from the use table.
	 * @param facilityID of facility to be removed
	 */
	public void removeFacilityUse(int facilityID) {
		try {
			System.out.println("*************** Removing facility from use table ...  " );
			Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			//System.out.println("*************** Hibernate session is created ..................\n" + session.toString());
			
			Query getFacilityQuery = session.createQuery("Delete from FacilityUseImpl where facility_id =" + facilityID);
			
			System.out.println("*************** Remove Query is ....>>\n" + getFacilityQuery.toString()); 
			getFacilityQuery.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("FacilityHibernateDAO: Threw an Exception removing "
			   		+ "from use table.");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/***
	 * List the name and ID number of all the facilities
	 * @return list of facilities
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Facility> listFacilities() {
		try {
			System.out.println("*************** Retrieving list of all facilities ...  " );
			Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			//System.out.println("*************** Hibernate session is created ..................\n" + session.toString());
			
			Query getFacilityQuery = session.createQuery("From FacilityImpl");
			
			System.out.println("*************** Retrieve Query is ....>>\n" + getFacilityQuery.toString()); 
			
			List facilities = getFacilityQuery.list();
			System.out.println("Getting Facilities using HQL. \n");
			
			
			session.getTransaction().commit();
			return facilities;
		} catch (Exception e) {
			System.err.println("FacilityHibernateDAO: Threw an Exception retreiving "
			   		+ "list of facilities.");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
		
	}
	
}

