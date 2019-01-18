package com.qa.biz.serv;

import javax.inject.Inject;

import com.qa.biz.serv.TraineeServ;
import com.qa.persist.repo.TraineeRepo;
//import com.qa.util.JSONUtil;
//import com.qa.persist.domain.Trainee;

public class TraineeServImp implements TraineeServ {

	@Inject
	private TraineeRepo repo;

	// @Inject
	// private JSONUtil util;

	@Override
	public String getTrainee() {
		return repo.getTrainee();
	}

	@Override
	public String createTrainee(String traineeJSON) {
		return repo.createTrainee(traineeJSON);
	}

	@Override
	public String updateTrainee(Long id, String traineeJSON) {
		return repo.updateTrainee(id, traineeJSON);
	}

	@Override
	public String deleteTrainee(Long id) {
		return repo.deleteTrainee(id);
	}

}