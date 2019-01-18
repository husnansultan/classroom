package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.biz.serv.TraineeServ;

@Path("/trainee")
public class TraineeEndpoint {
	
	@Inject
	private TraineeServ service;

	@Path("/getTrainee")
	@GET
	@Produces({ "application/json" })
	public String getTrainee() {
//		http://localhost:8080/classroom/api/account/getTrainee
		return service.getTrainee();
	}

	@Path("/createTrainee")
	@POST
	@Produces({ "application/json" })
	public String createTrainee(String traineeJSON) {
//		http://localhost:8080/classroom/api/account/createTrainee
		return service.createTrainee(traineeJSON);
	}

	@Path("/deleteTrainee/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("id") Long id) {
//		http://localhost:8080/classroom/api/account/deleteTrainee
		return service.deleteTrainee(id);
	}
	
	@Path("/updateTrainee/{id}")
	@POST
	@Produces({ "application/json" })
	public String updateTrainee(@PathParam("id") Long id,String traineeJSON) {
//		http://localhost:8080/classroom/api/account/getTrainee
		return service.updateTrainee(id, traineeJSON);
	}

	public void setService(TraineeServ service) {
		this.service = service;
	}

//  Post a new Account / Update	
//	{
//		firstName: Jane,
//		lastName: Do,
//		accountNumbe: 2
//	}
	
}