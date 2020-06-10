package ma.igoudconsulting.taskmanagement.service;

import java.util.List;
import java.util.Optional;

import ma.igoudconsulting.taskmanagement.model.Task;

public interface TaskService {
	Optional<Task> findOne(Long id);

	List<Task> findAll();

	void save(Task task);

	void update(Task task);

	void delete(Long id);

	void delete(Task task);

	int countByStateCode(String code);

	long count();

	List<Task> findByStateCode(String code);

}
