package com.qa.persist.repo;

public interface ClassroomRepo {
	
	String getClassroom();
	String createClassroom(String classroomJSON);
	String updateClassroom(Long id, String classroomJSON);
	String deleteClassroom(Long id);

}
