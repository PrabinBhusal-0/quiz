package com.quiz.Master.Quiz.service;

import com.quiz.Master.Quiz.entity.QuizQuestion;
import com.quiz.Master.Quiz.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    public List<QuizQuestion> getAllQuestions(){
        return questionRepo.findAll();
    }

    public QuizQuestion saveQuestion(QuizQuestion question){
        return questionRepo.save(question);
    }

    public QuizQuestion getQuestionById(Long id) {
        return questionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with ID: " + id));
    }

    public QuizQuestion updateQuestion(Long id, QuizQuestion updatedQuestion) {
        QuizQuestion existingQuestion = questionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with ID: " + id));

        existingQuestion.setQuestionText(updatedQuestion.getQuestionText());
        existingQuestion.setOptions(updatedQuestion.getOptions());
        existingQuestion.setCorrectAnswer(updatedQuestion.getCorrectAnswer());

        return questionRepo.save(existingQuestion);
    }

    public void deleteQuestionById(Long id) {
        QuizQuestion existingQuestion = questionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cannot delete. Question not found with ID: " + id));

        // Delete the question
        questionRepo.delete(existingQuestion);
    }


}
