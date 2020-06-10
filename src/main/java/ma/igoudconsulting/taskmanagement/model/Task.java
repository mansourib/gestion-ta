package ma.igoudconsulting.taskmanagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;

@Data
@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private Date createdDate;
	@ManyToOne
	private State state;

	@PrePersist
	void saveDate() {
		this.createdDate = new Date();
	}

	@PreUpdate
	void updateDate() {
		this.createdDate = new Date();
	}

}
