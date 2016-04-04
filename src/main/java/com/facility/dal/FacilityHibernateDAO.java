package com.facility.dal;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.facility.base.*;

public class FacilityHibernateDAO {
	
	
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
	
	public void addNewFacility(Facility fac) {
		System.out.println("*************** Adding facility to DB with ID ...  " + fac.getFacilityID());
		Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(fac);
		session.getTransaction().commit();
	}

	public void addFacilityDetail(int ID, int phoneNumber) {

	}
	
}
