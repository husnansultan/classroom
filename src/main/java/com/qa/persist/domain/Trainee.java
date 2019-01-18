package com.qa.persist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private Long trainee_ID;
	private String traineeName;

	public Trainee() {

	}

	public Trainee(Long trainee_ID, String traineeName) {
		this.setTraineeID(trainee_ID);
		this.setTraineeName(traineeName);
	}

	@Override
	public String toString() {
		return null;
	}

	public Long getTraineeID() {
		return trainee_ID;
	}

	public void setTraineeID(Long trainee_ID) {
		this.trainee_ID = trainee_ID;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

}
