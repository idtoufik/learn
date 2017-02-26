package fr.learn.course;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.learn.dao.Course;
import fr.learn.dao.Member;
import fr.learn.member.MemberService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/resources/courses", method = RequestMethod.GET )
	public List<Course> getAllCourses(){
		return courseService.findAll();
	}
	
	@RequestMapping(value="/resources/courses/{idCourse}", method = RequestMethod.GET)
	public  Course getCourse(@PathVariable("idCourse") long id){
		return courseService.findById(id);
	}
	
	@RequestMapping(value="/resources/courses" , method = RequestMethod.POST)
	public boolean addCourse(@RequestBody Course course){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Member loggedIn = memberService.getMemberFromAuthentification(auth);
		if(loggedIn == null)
			return false;
		course.setMember(loggedIn);
		course.setDateOfCreation(new Date());
		courseService.addCourse(course);
		return true;
	}
	
	@RequestMapping(value="/resources/courses/{idCourse}", method = RequestMethod.PUT)
	public Boolean modifyCourses(@RequestBody Course course, @PathVariable("idCourse") long id){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Member loggedIn = memberService.getMemberFromAuthentification(auth);
		if(loggedIn == null)
			return false;
		
		Course oldCourse = courseService.findById(id);
		if(oldCourse == null)
			return false;
		if(loggedIn.getId() == oldCourse.getMember().getId())
		{
			course.setId(id);
			course.setDateOfCreation(oldCourse.getDateOfCreation());
			course.setMember(loggedIn);
			courseService.modifyCourse(course);
			return true;
		}
		
		return false;
	}

	@RequestMapping(value="/resources/courses/{idCourse}", method = RequestMethod.DELETE)
	public boolean deleteCourse(@PathVariable("idCourse") long id){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Member loggedIn = memberService.getMemberFromAuthentification(auth);
		if(loggedIn == null)
			return false;
		
		Course course = courseService.findById(id);
		if(course == null)
			return false;
		
		if(loggedIn.getId() == course.getMember().getId())
		{
			courseService.deleteCourse(id);
			return true;
		}
		return false;
	}
	
}
