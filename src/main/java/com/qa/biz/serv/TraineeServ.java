package com.qa.biz.serv;

public interface TraineeServ {

	String getTrainee();

	String createTrainee(String traineeJSON);

	String updateTrainee(Long id, String traineeJSON);

	String deleteTrainee(Long id);

}