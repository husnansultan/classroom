package com.qa.persist.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Trainee {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private Long trainee_ID;
	private String traineeName;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "classroom_ID")
	private Long classroom_ID;

	public Trainee() {

	}

	public Trainee(Long trainee_ID, String traineeName, Long classroom_ID) {
		this.trainee_ID = trainee_ID;
		this.traineeName = traineeName;
		this.classroom_ID = classroom_ID;
	}

	@Override
	public String toString() {
		return null;
	}

	public Long getTrainee_ID() {
		return id;
	}

	public void setTrainee_ID(Long trainee_ID) {
		this.id = trainee_ID;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public Long getClassroom_ID() {
		return classroom_ID;
	}

	public void setClassroom_ID(Long classroom_ID) {
		this.classroom_ID = classroom_ID;
	}

}