
package fr.learn.lesson;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.learn.dao.Lesson;

/**
 * 
 */

@RestController
public class LessonController {

    /**
     * Default constructor
     */
    public LessonController() {
    }

    /**
     * @param long idCourse 
     * @param Lesson lesson
     */
    
    
    public  void addLesson( long idCourse, Lesson lesson) {
        // TODO implement here
    }

    /**
     * @param long idLesson
     */
    public  void deleteLesson( long idLesson) {
        // TODO implement here
    }

    /**
     * @param long idLesson 
     * @param Lesson lesson
     */
    public  void updateLesson( long idLesson,  Lesson lesson) {
        // TODO implement here
    }

    /**
     * @param long idLesson
     */
    public Lesson getLesson(long idLesson) {
        // TODO implement here
    	return null;
    }

    /**
     * 
     */
    public  List<Lesson> getAllLessons() {
        // TODO implement here
    	return null;
    }

}