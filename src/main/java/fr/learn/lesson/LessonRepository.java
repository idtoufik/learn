package fr.learn.lesson;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.learn.dao.Lesson;

/**
 * 
 */
public  interface LessonRepository extends JpaRepository<Lesson, Long>{

}