package fr.learn.exercise;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.learn.dao.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long>{

}
