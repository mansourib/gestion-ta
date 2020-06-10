package ma.igoudconsulting.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.igoudconsulting.taskmanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
