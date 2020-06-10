package ma.igoudconsulting.taskmanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.igoudconsulting.taskmanagement.model.Role;
import ma.igoudconsulting.taskmanagement.repository.RoleRepository;
import ma.igoudconsulting.taskmanagement.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository repository;

	@Override
	public Optional<Role> findOne(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Role> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Role Role) {
		repository.save(Role);

	}

	@Override
	public void update(Role Role) {
		repository.save(Role);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(Role Role) {
		repository.delete(Role);
	}

	@Override
	public Role findByCode(String code) {
		return repository.findByCode(code);
	}

}
