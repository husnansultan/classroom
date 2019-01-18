package com.qa.biz.serv;

public interface ClassroomServ {

	String getClassroom();

	String createClassroom(String classroomJSON);

	String updateClassroom(Long id, String classroomJSON);

	String deleteClassroom(Long id);

}