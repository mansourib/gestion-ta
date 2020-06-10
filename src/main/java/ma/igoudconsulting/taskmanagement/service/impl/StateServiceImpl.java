package ma.igoudconsulting.taskmanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.igoudconsulting.taskmanagement.model.State;
import ma.igoudconsulting.taskmanagement.repository.StateRepository;
import ma.igoudconsulting.taskmanagement.service.StateService;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository repository;

	@Override
	public Optional<State> findOne(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<State> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(State State) {
		repository.save(State);

	}

	@Override
	public void update(State State) {
		repository.save(State);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(State State) {
		repository.delete(State);
	}

	@Override
	public State findByCode(String code) {
		return repository.findByCode(code);
	}

}
