package com.exerciseplanner;

import java.io.File;

public class AthleteFitnessPlanBuilder extends FitnessPlanBuilder {
    
	public AthleteFitnessPlanBuilder(){
		p.planType="AtheleteFitnessPlan";
	}
	
	@Override
	public void getWorkout() {
		// TODO Auto-generated method stub
		//w=new AtheleteWorkout();
		File file=new File("AthleteWorkout.xml");
		p.setWorkoutFile(file);
	}

	@Override
	public void getFitnessTraining() {
		// TODO Auto-generated method stub
		//f=new AtheleteFitnessTraining();
		File file=new File("AthleteFitnessTraining.xml");
		p.setFitnessTrainingFile(file);
	}

	@Override
	public void getDiet() {
		// TODO Auto-generated method stub
		//d= new AtheleteDiet();
		File file = new File("AthleteDiet.xml");
		p.setDietFile(file);
	}
}
