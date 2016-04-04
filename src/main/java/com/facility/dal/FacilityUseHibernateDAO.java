package com.facility.dal;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.facility.base.Facility;
import com.facility.use.Inspection;

public class FacilityUseHibernateDAO {

	public List<Inspection> listInspections(Facility fac) {
		try {
			//System.out.println("*************** Retrieving a list of Inspections for Facility ...  " + fac.getFacilityID());
			//Session session = HibernatePGSQLHelper.getSessionFactory().getCurrentSession();
			//session.beginTransaction();
			
			//System.out.println("*************** Hibernate session is created ..................\n" + session.toString());
			
			//Query getCustQuery = session.createQuery("From CustomerImpl ");
			//Query getInspectionsQuery = session.createQuery("From InspectionImpl where facility_ID =" + fac.getFacilityID());		
			
			//System.out.println("*************** Retrieve Query is ....>>\n" + getInspectionsQuery.toString()); 
			
			//List<Inspection> inspections = new ArrayList<Inspection>();
			//List<Inspection> inspectionsQ = getInspectionsQuery.list();
			//session.getTransaction().commit();
			
			//List<Inspection> inspections = new ArrayList<Inspection>();
			//inspections.addAll(inspectionsQ);
			//return (Customer)customers.get(0);
			//return inspections;
			return null;
		} catch (Exception e) {
			System.err.println("UseHibernateDAO: Threw an Exception retreiving "
			   		+ "inspections from InspectionsImpl.");
			   System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
}
