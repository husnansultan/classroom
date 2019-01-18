package com.qa.biz.serv;

import javax.inject.Inject;

import com.qa.biz.serv.ClassroomServ;
//import com.qa.persist.domain.Classroom;
import com.qa.persist.repo.ClassroomRepo;

public class ClassroomServImp implements ClassroomServ {

	@Inject
	private ClassroomRepo repo;

	// @Inject
	// private JSONUtil util;

	@Override
	public String getClassroom() {
		return repo.getClassroom();
	}

	@Override
	public String createClassroom(String classroomJSON) {
		return repo.createClassroom(classroomJSON);
	}

	@Override
	public String updateClassroom(Long id, String classroomJSON) {
		return repo.updateClassroom(id, classroomJSON);
	}

	@Override
	public String deleteClassroom(Long id) {
		return repo.deleteClassroom(id);
	}

}