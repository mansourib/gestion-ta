package ma.igoudconsulting.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.igoudconsulting.taskmanagement.model.State;

public interface StateRepository extends JpaRepository<State, Long> {

	State findByCode(String code);

}
