package ma.igoudconsulting.taskmanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.igoudconsulting.taskmanagement.model.UserTask;
import ma.igoudconsulting.taskmanagement.repository.UserTaskRepository;
import ma.igoudconsulting.taskmanagement.service.UserTaskService;

@Service
public class UserTaskServiceImpl implements UserTaskService {

	@Autowired
	private UserTaskRepository repository;

	@Override
	public Optional<UserTask> findOne(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<UserTask> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(UserTask userTask) {
		repository.save(userTask);
	}

	@Override
	public void update(UserTask userTask) {
		repository.save(userTask);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(UserTask userTask) {
		repository.delete(userTask);
	}

	@Override
	public List<UserTask> findByUserEmailAndTaskStateCode(String email, String code) {
		return repository.findByUserEmailAndTaskStateCode(email, code);
	}

	@Override
	public List<UserTask> findByUserEmail(String email) {
		return repository.findByUserEmail(email);
	}

}
