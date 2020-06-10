package ma.igoudconsulting.taskmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.igoudconsulting.taskmanagement.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	int countByStateCode(String code);

	List<Task> findByStateCode(String code);
}
