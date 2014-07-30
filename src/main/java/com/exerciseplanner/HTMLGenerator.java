package com.exerciseplanner;

import java.util.ArrayList;

public class HTMLGenerator implements DocumentGenerator {
	String htmlString="<link href='css/bootstrap.min.css' rel='stylesheet'><link href='css/custom.css' rel='stylesheet'><script src='http://code.jquery.com/jquery-latest.min.js'></script><script src='js/bootstrap.min.js'></script>";
	public HTMLGenerator(){
		htmlString=htmlString+"<div class='container jumbotron page-header' style='background-color: #5bc0de;'><h2><large> BoFit Inc.</large></h2></div>";
	}
	
	@Override
	public String generateDocument(Plan plan,Person p) {
		// TODO Auto-generated method stub
		
		
		htmlString=htmlString+"<div class='container'><div><h2>"+plan.planType+"</h2><br><div>";

		if(p!=null){
			htmlString=htmlString+"<strong>Name:</strong>"+p.firstName+" "+p.lastName+"</br>";
			htmlString=htmlString+"<strong>Age:</strong>"+p.age+"</br>";
			htmlString=htmlString+"<strong>E-Mail:</strong>"+p.Email+"</br>";
		}
		if(plan.workoutFile!=null){
			//Workout Details
			
			ArrayList<ArrayList<String>> workoutData=plan.getWorkoutData();//getData();
    
			htmlString=htmlString+"<table class='table table-bordered'>";
			htmlString=htmlString+"<tr><h3>Workout</h3></tr>";
			htmlString=htmlString+"<tr><th><strong>Type</strong></th>";
			htmlString=htmlString+"<th><strong>Duration</strong></th>";
			htmlString=htmlString+"<th><strong>Machine</strong></th>";
			htmlString=htmlString+"<th><strong>Fee</strong></th></tr>";

			for(int i=0;i<workoutData.size();i++){
				ArrayList<String> dataRecord=workoutData.get(i);
				htmlString=htmlString+"<tr>";
				for(int k=0;k<dataRecord.size();k++){
					htmlString=htmlString+"<td>"+dataRecord.get(k)+"</td>";
				}
				htmlString=htmlString+"</tr>";
			}
		}
		
		if(plan.fitnessTrainingFile!=null){
			// FitnessTraining Details
			
			ArrayList<ArrayList<String>> fitnessData=plan.getFitnessData();

			htmlString=htmlString+"<table class='table table-bordered'>";
			htmlString=htmlString+"<tr><h3>Fitness Training</h3></tr>";
			htmlString=htmlString+("<tr><th><strong>Name</strong></th>");
			htmlString=htmlString+("<th><strong>Schedule</strong></th>");
			htmlString=htmlString+("<th><strong>Fee</strong></th></tr>");

			for(int i=0;i<fitnessData.size();i++){
				ArrayList<String> dataRecord=fitnessData.get(i);
				htmlString=htmlString+("<tr>");
				for(int k=0;k<dataRecord.size();k++){
					htmlString=htmlString+("<td>"+dataRecord.get(k)+"</td>");
				}
				htmlString=htmlString+("</tr>");
			}

		}		
		
		if(plan.dietFile!=null){
			//Diet Details
			
			ArrayList<ArrayList<String>> dietData=plan.getDietData();

			htmlString=htmlString+("<table class='table table-bordered'>");
			htmlString=htmlString+("<tr><h3>Diet</h3></tr>");
			htmlString=htmlString+("<tr><th><strong>Calories</strong></th>");
			htmlString=htmlString+("<th><strong>MealPlan</strong></th>");
			htmlString=htmlString+("<th><strong>Recommendation</strong></th>");
			htmlString=htmlString+("<th><strong>Fee</strong></th></tr>");

			for(int i=0;i<dietData.size();i++){
				ArrayList<String> dataRecord=dietData.get(i);
				htmlString=htmlString+("<tr>");
				for(int k=0;k<dataRecord.size();k++){
					htmlString=htmlString+("<td>"+dataRecord.get(k)+"</td>");
				}
				htmlString=htmlString+("</tr>");
			}
		}
		return htmlString+"</div>";
	}

}
