package fr.learn.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.learn.dao.Course;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value="/resources/courses", method = RequestMethod.GET )
	public List<Course> getAllCourses(){
		return courseService.findAll();
	}
	
	@RequestMapping(value="/resources/courses/{idCourse}", method = RequestMethod.GET)
	public  Course getCourse(@PathVariable("idCourse") long id){
		return courseService.findById(id);
	}
	
	@RequestMapping(value="/resources/courses" , method = RequestMethod.POST)
	public void addCourse(@RequestBody Course course){
		courseService.addCourse(course);
	}
	
	@RequestMapping(value="/resources/courses/{idCourse}", method = RequestMethod.POST)
	public void modifyCourses(@RequestBody Course course, @PathVariable("idCourse") long id){
		course.setId(id);
		courseService.addCourse(course);
	}

	@RequestMapping(value="/resources/courses/{idCourse}", method = RequestMethod.DELETE)
	public void deleteCourse(@PathVariable("idCourse") long id){
		courseService.deleteCourse(id);
	}
	
}
