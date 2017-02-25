package fr.learn.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.learn.dao.Course;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> findAll(){
		 List<Course> courses = new ArrayList<>();
		 courseRepository.findAll().forEach(courses::add);
		 return courses;
	}
	
	public Course findById(long id){
		 return courseRepository.findOne(id);
	}
	
	public void addCourse(Course course){
		courseRepository.save(course);
	}
	
	public void deleteCourse(long id){
		courseRepository.delete(id);
	}
	
	public void modifyCourse(Course course){
		courseRepository.save(course);
	}
	
}
