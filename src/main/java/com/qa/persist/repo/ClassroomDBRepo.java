package com.qa.persist.repo;

import com.qa.persist.domain.Classroom;
import com.qa.util.JSONUtil;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepo implements ClassroomRepo {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Transactional(REQUIRED)
	public String getClassroom() {
		Query query = manager.createQuery("Select a FROM Account a");
		@SuppressWarnings("unchecked")
		Collection<Classroom> classrooms = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(classrooms);
	}

	@Transactional(REQUIRED)
	public String createClassroom(String classroomJSON) {
		Classroom newClassroom = util.getObjectForJSON(classroomJSON, Classroom.class);
		manager.persist(newClassroom);
		return "{\"message\": \"classroom has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateClassroom(Long id, String classroomJSON) {
		Classroom classroomInDB = findClassroom(id);
		Classroom newClassroom = util.getObjectForJSON(classroomJSON, Classroom.class);
		if (classroomInDB != null) {
			manager.remove(classroomInDB);
			manager.persist(newClassroom);
			return "{\"message\": \"has been sucessfully updated\"}";
		}
		return "{\"message\": \"The classroom ID is invalid\"}";
	}

	@Transactional(REQUIRED)
	public String deleteClassroom(Long id) {
		Classroom classroomInDB = findClassroom(id);
		if (classroomInDB != null) {
			manager.remove(classroomInDB);
			return "{\"message\": \"classroom sucessfully deleted\"}";
		}
		return "{\"message\": \"invalid classroom ID so did not work\"}";
	}

	private Classroom findClassroom(Long id) {
		return manager.find(Classroom.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}