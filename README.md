# Facility-Management-System-Java
COMP 373/474 - Objects/Frameworks/Patterns - Spring 2016 - Project 2 using PostgreSQL on Heroku and Spring + Hibernate Frameworks

###Project 2: Object Wiring Using Spring and O/R Mapping Using Hibernate – A Facility Management System 


**Project Description:**

In this project, we will change the object dependency and collaboration management from directly
instantiating to Dependency Injection container (Spring). We will also change the data access
mechanism from JDBC to O/R Mapping tool (hibernate). 

- Domain Modeling and implementation and mapping domain model to persistence model
- Implementing the data access layer by designing and implementing the persistence layer using
relational tables to map to objects and the required/necessary data access objects. 

You need to design and implement: 

- Spring container configuration for Dependency Injection for the application that you developed in [Project 1](https://github.com/csoulakian/Facility-Management-System-Java).
- Using ApplicationContext Mechanism
- Dependency relationship using XML
- O/R Mapping between classes and tables in XML
- Hibernate configuration 

###Facility Management System Design (from [Project 1](https://github.com/csoulakian/Facility-Management-System-Java))

**System Name:** Facility Management System

**System Description:** Facilities are the building units (buildings and rooms inside) that a company
uses to support the activities of the business. This system will support the management of buildings,
their constant use, and maintenance support when it is needed. The following are the three main
functionalities of this system:

1. Facility and its description - this will cover the functionalities such as adding a new facility to
be managed; removing a facility from being managed; getting general information such as
the number and capacity of facilities and their current statuses.
2. Facility use – this covers the functionalities of managing the facility such as reserving a
facility; the cost of using and maintaining it; assigning and de-assigning a facility for use.
3. Facility maintenance – this functionality covers the maintenance of a facility such as
scheduling a facility for maintenance; checking maintenance status; listing maintenance
requests; calculating down time of a facility and many more functionalities.

**Client Interfaces:**

- Facility:
  - public object listFacilities ()
  - public object getFacilityInformation()
  - public object requestAvailableCapacity()
  - public object addNewFacility()
  - public void addFacilityDetail()
  - public object removeFacility()
- Facility Use:
  - public object isInUseDuringInterval()
  - public object assignFacilityToUse()
  - public object vacateFacility()
  - public object listInspections()
  - public object listActualUsage()
  - public object calcUsageRate()
- Facility Maintenance: 
  - public object makeFacilityMaintRequest()
  - public object scheduleMaintenance()
  - public object calcMaintenanceCostForFacility()
  - public object calcProblemRateForFacility()
  - public object calcDownTimeForFacility()
  - public object listMaintRequests()
  - public object listMaintenance()
  - public object listFacilityProblems() 
