package com.qa.persist.repo;

public interface TraineeRepo {
	
	String getTrainee();
	
	String createTrainee(String traineeJSON);

	String updateTrainee(Long id, String traineeJSON);

	String deleteTrainee(Long id);

}