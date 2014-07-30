package com.exerciseplanner;

public abstract class FitnessPlanBuilder {
	
	DocumentGenerator doc;
	Plan p=new Plan();
	
	public Plan getPlan(){
		return p;
	}
	
	public abstract void getWorkout();
	public abstract void getFitnessTraining();
	public abstract void getDiet();
	
}
