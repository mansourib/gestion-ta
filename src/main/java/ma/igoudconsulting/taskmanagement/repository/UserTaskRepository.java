package ma.igoudconsulting.taskmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.igoudconsulting.taskmanagement.model.UserTask;

public interface UserTaskRepository extends JpaRepository<UserTask, Long> {

	List<UserTask> findByUserEmailAndTaskStateCode(String email, String code);

	List<UserTask> findByUserEmail(String email);
}
