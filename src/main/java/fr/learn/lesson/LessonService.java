
package fr.learn.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.learn.dao.Lesson;

/**
 * 
 */
@Service
public class LessonService {

    /**
     * Default constructor
     */
	@Autowired
	private LessonRepository lessonRepository;
    public LessonService() {
    }

    /**
     * @param Lesson lesson
     */
    public void addLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    /**
     * @param long idLesson
     */
    public void deleteLesson(long idLesson) {
        lessonRepository.delete(idLesson);
    }

    /**
     * @param Lesson lesson
     */
    public void updateLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    /**
     * @param long idLesson
     */
    public  Lesson getLesson(long idLesson) {
    	return lessonRepository.findOne(idLesson);
    }

    /**
     * 
     */
    public  List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

}