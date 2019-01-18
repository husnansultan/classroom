package com.qa.biz.serv;

import javax.inject.Inject;

import com.qa.biz.serv.ClassroomServ;
import com.qa.persist.repo.ClassroomRepo;
//import com.qa.persist.domain.Classroom;
//import com.qa.util.JSONUtil;

public class ClassroomServImp implements ClassroomServ {

	@Inject
	private ClassroomRepo repo;
//	@Inject
//	private JSONUtil util;

	@Override
	public String getClassroom() {
		return repo.getClassroom();
	}

	@Override
	public String createClassroom(String classroomJSON) {
		return null;
	}

	@Override
	public String updateClassroom(Long id, String classroomJSON) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteClassroom(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
