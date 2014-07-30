package com.exerciseplanner;

import java.io.File;
import java.util.ArrayList;

import org.w3c.dom.Document;

public class Plan {
   File workoutFile=null;
   File fitnessTrainingFile=null;
   File dietFile=null;
   String planType;
   
   public void setWorkoutFile(File file){
	   this.workoutFile=file;
   }
   
   public void setFitnessTrainingFile(File file){
	   this.fitnessTrainingFile=file;
   }
   
   public void setDietFile(File file){
	   this.dietFile=file;
   }
   
   public ArrayList<ArrayList<String>> getDataList(File file,String headerTag,String[] tags){
		Document parsedXML=XMLReader.parseXML(file);
		ArrayList<ArrayList<String>> dataList=XMLReader.returnXMLTags(parsedXML, headerTag, tags);  
		return dataList;
	}
	
	public ArrayList<ArrayList<String>> getWorkoutData(){
		String[] tags={"Type","Duration","Machine","Fee"};
		return getDataList(workoutFile,"Workout",tags);
	}
   
	public ArrayList<ArrayList<String>> getFitnessData(){
		String[] tags={"TrainingName","Schedule","Fee"};
		return getDataList(fitnessTrainingFile,"FitnessTraining",tags);
	}
	
	public ArrayList<ArrayList<String>> getDietData(){
		String[] tags={"Calories","MealPlan","Recommendation","Fee"};
		return getDataList(dietFile,"Diet",tags);
	}
   
}
