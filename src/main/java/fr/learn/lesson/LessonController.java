
package fr.learn.lesson;

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

import fr.learn.course.CourseService;
import fr.learn.dao.Course;
import fr.learn.dao.Lesson;
import fr.learn.dao.Member;
import fr.learn.member.MemberService;

/**
 * 
 */

@RestController
public class LessonController {

	@Autowired
	private LessonService lessonService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private MemberService memberService;
	
	
	

    public LessonController() {
    }

    @RequestMapping(value="/resources/courses/{idCourse}/lessons/{idLesson}", 
    		method=RequestMethod.GET)
    public Lesson getLesson(@PathVariable long idLesson) {
        return lessonService.getLesson(idLesson);
    }

    @RequestMapping(value="/resources/courses/{idCourse}/lessons/", 
    		method=RequestMethod.GET)
    public  List<Lesson> getAllLessonsOfCourse(@PathVariable Long idCourse) {
    	
    	return lessonService.getAllLessonsOfCourse(idCourse);
    }
    
    @RequestMapping(value="/resources/courses/{idCourse}/lessons/", method=RequestMethod.POST)
    public  boolean addLesson(@PathVariable long idCourse, @RequestBody Lesson lesson) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Member loggedIn = memberService.getMemberFromAuthentification(auth);
		
		if(loggedIn == null)
			return false;
		Course course = courseService.findById(idCourse);
		
		if(course == null)
			return false;
		
		if(loggedIn.getId() == course.getMember().getId())
		{
			lesson.setCourse(course);
			lesson.setDateOfCreation(new Date());
			lessonService.addLesson(lesson);
			return true;
		}
		
		return false;
    }

  
    
    @RequestMapping(value="/resources/courses/{idCourse}/lessons/{idLesson}", method=RequestMethod.DELETE)
    public  boolean deleteLesson(@PathVariable long idLesson) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Member loggedIn = memberService.getMemberFromAuthentification(auth);
		
		if(loggedIn == null)
			return false;
		Lesson lesson = lessonService.getLesson(idLesson);
		if(lesson == null)
			return false;
		
		if(lesson.getCourse().getMember().getId() == loggedIn.getId())
		{
			lessonService.deleteLesson(idLesson);
			return true;
		}
		
		return false;
    }

    @RequestMapping(value="/resources/courses/{idCourse}/lessons/{idLesson}", method=RequestMethod.PUT)
    public  boolean updateLesson(@PathVariable long idLesson,@RequestBody  Lesson lesson) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Member loggedIn = memberService.getMemberFromAuthentification(auth);
		
		if(loggedIn == null)
			return false;
		Lesson oldLesson = lessonService.getLesson(idLesson);
		if(oldLesson == null)
			return false;
		
		if(oldLesson.getCourse().getMember().getId() == loggedIn.getId())
		{
			lesson.setId(idLesson);
			lesson.setCourse(oldLesson.getCourse());
			lesson.setDateOfCreation(oldLesson.getDateOfCreation());
			lessonService.updateLesson(lesson);
			return true;
		}
		return false;
		
    }

    

}