package com.facility.view;


import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.facility.base.*;
import com.facility.service.*;

public class FacilityClient {

	public FacilityClient() throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/app-context.xml");
        System.out.println("***************** Application Context instantiated! ******************");
		
		FacilityService facService = (FacilityService) context.getBean("facilityService");
		
		//set up facilities for dummy data
		Facility fact1 = (Facility) context.getBean("facility");
		FacilityDetail factDet1 = (FacilityDetail) context.getBean("facilityDetail");
		fact1.setFacilityID(1);
		factDet1.setFacilityID(1);
		factDet1.setFacility(fact1);
		factDet1.setNumberOfRooms(2);
		fact1.setFacilityDetail(factDet1);
		
/*		Facility fact3 = (Facility) context.getBean("facility");
		FacilityDetail factDet3 = (FacilityDetail) context.getBean("facilityDetail");
		fact3.setFacilityID(3);
		factDet3.setNumberOfRooms(6);
		fact3.setFacilityDetail(factDet3);
		
		Facility fact4 = (Facility) context.getBean("facility");
		FacilityDetail factDet4 = (FacilityDetail) context.getBean("facilityDetail");
		fact4.setFacilityID(4);
		factDet4.setNumberOfRooms(5);
		fact4.setFacilityDetail(factDet4);
		
		Facility fact7 = (Facility) context.getBean("facility");
		FacilityDetail factDet7 = (FacilityDetail) context.getBean("facilityDetail");
		fact7.setFacilityID(7);
		factDet7.setNumberOfRooms(10);
		fact7.setFacilityDetail(factDet7);
		
*/	
		System.out.println("\nFacilityClient: *************** Instantiating a facility and its details *************************");
        Facility fact = (Facility) context.getBean("facility");
		fact.setFacilityID(11);
		FacilityDetail detail = (FacilityDetail) context.getBean("facilityDetail");
		detail.setFacility(fact);
		detail.setName("IT Center");
		detail.setNumberOfRooms(4);
		detail.setFacilityID(11);
		//detail.setPhoneNumber(5550123);
        fact.setFacilityDetail(detail); 
      
        //save facility information
        //Saving the newly created facility and its details
        facService.addNewFacility(fact);
        System.out.println("FacilityClient: *************** Facility is inserted in Facility Database *************************");
        
        
		
        System.out.println("FacilityClient: *************** Trying to get information about this facility in the database ***************");
        
        FacilityDetail searchedFacilityDetail = facService.getFacilityInformation(fact.getFacilityID()); 
        
        
        System.out.println("\nFacilityClient: *************** Here is searched facility information *************************");
        System.out.println("\n\tFacility ID:   \t\t" + searchedFacilityDetail.getFacilityID());
        System.out.println("\tInfo About Facility:  \t" + searchedFacilityDetail.getName() + 
          		"\n\t\t\t\t Number of Rooms:" + searchedFacilityDetail.getNumberOfRooms()); 
        if (searchedFacilityDetail.getPhoneNumber() != 0) {
        	System.out.print("\t\t\t\t Phone Number: " + searchedFacilityDetail.getPhoneNumber() +
        	"\n\t\t\t\t" + "\n");
        } else {
        	System.out.print("\t\t\t\t Phone Number: unlisted" +
                	"\n\t\t\t\t" + "\n");
        }
        
        		
        
        /*//add optional phone number to facility detail
		facService.addFacilityDetail(11, 3120136);
		
		Facility updatedFacility = facService.getFacilityInformation(11); 
		FacilityDetail facilityNewDet = updatedFacility.getFacilityDetail();
		
		System.out.println("\nFacilityClient: *************** Here is the updated facility information *************************");
        System.out.println("\n\tFacility ID:   \t\t" + updatedFacility.getFacilityID());
        System.out.println("\tInfo About Facility:  \t" + facilityNewDet.getName() + 
          		"\n\t\t\t\t Number of Rooms: " + facilityNewDet.getNumberOfRooms()); 
        if (facilityNewDet.getPhoneNumber() != 0) {
        	System.out.print("\t\t\t\t Phone Number: " + facilityNewDet.getPhoneNumber() +
        	"\n\t\t\t\t" + "\n");
        } else {
        	System.out.print("\t\t\t\t Phone Number: unlisted" +
                	"\n\t\t\t\t" + "\n");
        }
		
        
		System.out.println("\nFacilityClient: *************** Remove a facility from the database *************************");
        facService.removeFacility(11);
        System.out.println("************ Facility Removed ************");
        
        System.out.println("\nFacilityClient: *************** An updated list of all the facilities *************************");
        List<Facility> listOfFacilities = facService.listFacilities();
        for (Facility fac : listOfFacilities) {
        	FacilityDetail facDet = fac.getFacilityDetail();
        	System.out.println("\n\t" + facDet.getName() + " ID: " + fac.getFacilityID());
        }
        

        System.out.println("\nFacilityClient: *************** Request available capacity of a facility *************************");
        //uses sample data
        int roomsAvail = facService.requestAvailableCapacity(fact4);
		System.out.println("There are " + roomsAvail + " rooms currently available at Facility #" + fact4.getFacilityID() + ".");
        */
	}
}
