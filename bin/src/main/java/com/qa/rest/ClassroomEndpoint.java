package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.biz.serv.ClassroomServ;

@Path("/classroom")
public class ClassroomEndpoint {
	
	@Inject
	private ClassroomServ service;

	@Path("/getClassroom")
	@GET
	@Produces({ "application/json" })
	public String getClassroom() {
//		http://localhost:8080/classroom/api/account/getClassroom
		return service.getClassroom();
	}

	@Path("/createClassroom")
	@POST
	@Produces({ "application/json" })
	public String createClassroom(String classroomJSON) {
//		http://localhost:8080/classroom/api/account/createClassroom
		return service.createClassroom(classroomJSON);
	}

	@Path("/deleteClassroom/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassroom(@PathParam("id") Long id) {
//		http://localhost:8080/classroom/api/account/deleteClassroom
		return service.deleteClassroom(id);
	}
	
	@Path("/updateClassroom/{id}")
	@POST
	@Produces({ "application/json" })
	public String updateClassroom(@PathParam("id") Long id,String classroomJSON) {
//		http://localhost:8080/classroom/api/account/getClassroom
		return service.updateClassroom(id, classroomJSON);
	}

	public void setService(ClassroomServ service) {
		this.service = service;
	}

//  Post a new Account / Update	
//	{
//		firstName: Jane,
//		lastName: Do,
//		accountNumbe: 2
//	}
	
}