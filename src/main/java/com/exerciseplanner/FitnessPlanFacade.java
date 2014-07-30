package com.exerciseplanner;

public class FitnessPlanFacade {
    String[] services;
    String planType;
    String documentType;
    ExercisePlanDirector d;
    Plan plan;
    DocumentGenerator doc;
    
    
	public FitnessPlanFacade(String[] services,String planType,String documentType){
		this.services=services;
		this.planType=planType;
		this.documentType=documentType;
	}
	
	public String constructSystem(String firstname,String lastname, String Email,String age){
		FitnessPlanBuilder planBuilder;

		if(planType.equals("AtheletePlan")){
			planBuilder = new AthleteFitnessPlanBuilder();
		}
		else if(planType.equals("RegularPlan")){
			planBuilder = new RegularFitnessPlanBuilder();
		}
		else if(planType.equals("SeniorPlan")){
			planBuilder = new SeniorFitnessPlanBuilder();
		}
		else{
			planBuilder=null;
		}
		 d=new ExercisePlanDirector(planBuilder,services);
		if(planBuilder!=null){
			plan=planBuilder.getPlan();

			Person p=null;
			if(documentType.equals("MembershipDocument")){
			    p=new Person();
				p.firstName=firstname;
				p.lastName=lastname;
				p.age=age;
				p.Email=Email;
				
			}
			
			doc=new HTMLGenerator();
			return doc.generateDocument(plan,p);
		}
		
		return null;
	}
	
}
