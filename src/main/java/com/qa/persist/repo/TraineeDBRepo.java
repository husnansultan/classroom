package com.qa.persist.repo;

import com.qa.persist.domain.Trainee;
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
public class TraineeDBRepo implements TraineeRepo {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Transactional(REQUIRED)
	public String getTrainee() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(trainees);
	}

	@Transactional(REQUIRED)
	public String createTrainee(String traineeJSON) {
		Trainee newTrainee = util.getObjectForJSON(traineeJSON, Trainee.class);
		manager.persist(newTrainee);
		return "{\"message\": \"Trainee has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateTrainee(Long id, String traineeJSON) {
		Trainee traineeInDB = findTrainee(id);
		Trainee newTrainee = util.getObjectForJSON(traineeJSON, Trainee.class);
		if (traineeInDB != null) {
			manager.remove(traineeInDB);
			manager.persist(newTrainee);
			return "{\"message\": \"Trainee has been sucessfully updated\"}";
		}
		return "{\"message\": \"The Trainee ID is invalid\"}";
	}

	public String deleteTrainee(Long id) {
		Trainee traineeInDB = findTrainee(id);
		if (traineeInDB != null) {
			manager.remove(traineeInDB);
			return "{\"message\": \"trainee sucessfully deleted\"}";
		}
		return "{\"message\": \"invalid trainee ID so did not work\"}";
	}

	private Trainee findTrainee(Long id) {
		return manager.find(Trainee.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}