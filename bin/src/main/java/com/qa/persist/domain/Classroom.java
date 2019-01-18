package com.qa.persist.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	Long classroom_ID;
	private String trainer;
	
	@OneToMany(
	        mappedBy = "post",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true,
	        fetch = FetchType.EAGER
	    )
	@JoinColumn(name = "trainee_ID")
	private List<Trainee> trainee_ID;

	public Classroom() {

	}

	public Classroom(Long classroom_ID, String trainer, List<Trainee> trainee_ID) {
		this.classroom_ID = classroom_ID;
		this.trainer = trainer;
		this.trainee_ID = trainee_ID;
	}

	@Override
	public String toString() {
		return null;
	}

	public Long getClassroom_ID() {
		return id;
	}

	public void setClassroom_ID(Long classroom_ID) {
		this.id = classroom_ID;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public List<Trainee> getTrainee_ID() {
		return trainee_ID;
	}

	public void setTrainee_ID(List<Trainee> trainee_ID) {
		this.trainee_ID = trainee_ID;
	}

}