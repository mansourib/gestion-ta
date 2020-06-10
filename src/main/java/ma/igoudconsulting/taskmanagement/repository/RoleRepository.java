package ma.igoudconsulting.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.igoudconsulting.taskmanagement.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByCode(String code);

}
