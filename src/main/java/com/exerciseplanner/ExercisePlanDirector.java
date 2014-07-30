package com.exerciseplanner;

public class ExercisePlanDirector {
	FitnessPlanBuilder plan;
    
	public ExercisePlanDirector(FitnessPlanBuilder plan,String[] services){
		this.plan=plan;
		if(services.length>=2){
			for(int i=0;i<services.length;i++){
				if(services[i].equals("Workout")){
					plan.getWorkout();
				}
				if(services[i].equals("Fitness")){
					plan.getFitnessTraining();
				}
				if(services[i].equals("Diet")){
					plan.getDiet();
				}
			}
		}
	}
}
