package com.quiz.Master.Quiz.repo;

import com.quiz.Master.Quiz.entity.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<QuizQuestion,Long> {

}
