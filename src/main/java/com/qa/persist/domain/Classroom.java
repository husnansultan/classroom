package com.qa.persist.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
	
	private Long classroom_ID;
	private String trainer;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "trainee_ID")
	private List<Trainee> trainees = new ArrayList<>();

	public Classroom() {

	}

	public Classroom(Long classroom_ID, String trainer, List<Trainee> trainees ) {
		this.setClassroomID(classroom_ID);
		this.setTrainer(trainer);
		this.setTrainees(trainees);
	}

	@Override
	public String toString() {
		return null;
	}

	public Long getClassroomID() {
		return classroom_ID;
	}

	public void setClassroomID(Long classroomID) {
		this.classroom_ID = classroomID;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public List<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}

}