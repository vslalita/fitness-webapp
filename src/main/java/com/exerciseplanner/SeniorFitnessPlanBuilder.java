package com.exerciseplanner;

import java.io.File;

public class SeniorFitnessPlanBuilder extends FitnessPlanBuilder {
	
	public SeniorFitnessPlanBuilder(){
		p.planType="SeniorFitnessPlan";
	}
	@Override
	public void getWorkout() {
		// TODO Auto-generated method stub
		//w=new AtheleteWorkout();
		File file=new File("SeniorWorkout.xml");
		p.setWorkoutFile(file);
	}

	@Override
	public void getFitnessTraining() {
		// TODO Auto-generated method stub
		//f=new AtheleteFitnessTraining();
		File file=new File("SeniorFitnessTraining.xml");
		p.setFitnessTrainingFile(file);
	}

	@Override
	public void getDiet() {
		// TODO Auto-generated method stub
		//d= new AtheleteDiet();
		File file = new File("SeniorDiet.xml");
		p.setDietFile(file);
	}
}
