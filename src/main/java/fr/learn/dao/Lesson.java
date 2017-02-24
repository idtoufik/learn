package fr.learn.dao;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="lesson")
public class Lesson {
	private long id;
	private String title;
	private String content;
	private Course course;
	private Set<Exercise> exercises;
	
	public Lesson() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@OneToMany(mappedBy="lesson")
	public Set<Exercise> getExercises() {
		return exercises;
	}
	public void setExercises(Set<Exercise> exercises) {
		this.exercises = exercises;
	}

	@ManyToOne
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
}
