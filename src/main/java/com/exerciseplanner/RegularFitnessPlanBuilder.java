package com.exerciseplanner;

import java.io.File;

public class RegularFitnessPlanBuilder extends FitnessPlanBuilder {

	public RegularFitnessPlanBuilder(){
		p.planType="RegularFitnessPlan";
	}
	@Override
	public void getWorkout() {
		// TODO Auto-generated method stub
		//w=new AtheleteWorkout();
		File file=new File("RegularWorkout.xml");
		p.setWorkoutFile(file);
	}

	@Override
	public void getFitnessTraining() {
		// TODO Auto-generated method stub
		//f=new AtheleteFitnessTraining();
		File file=new File("RegularFitnessTraining.xml");
		p.setFitnessTrainingFile(file);
	}

	@Override
	public void getDiet() {
		// TODO Auto-generated method stub
		//d= new AtheleteDiet();
		File file = new File("RegularDiet.xml");
		p.setDietFile(file);
	}
}
