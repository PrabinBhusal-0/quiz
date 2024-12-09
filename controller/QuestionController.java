package com.quiz.Master.Quiz.controller;

import com.quiz.Master.Quiz.entity.QuizQuestion;
import com.quiz.Master.Quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    // Get all questions
    @GetMapping
    public ResponseEntity<List<QuizQuestion>> getAllQuestions() {
        List<QuizQuestion> questions = questionService.getAllQuestions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    // Get a question by ID
    @GetMapping("/{id}")
    public ResponseEntity<QuizQuestion> getQuestionById(@PathVariable Long id) {
        QuizQuestion question = questionService.getQuestionById(id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    // Save a new question
    @PostMapping
    public ResponseEntity<QuizQuestion> saveQuestion(@RequestBody QuizQuestion question) {
        QuizQuestion savedQuestion = questionService.saveQuestion(question);
        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
    }

    // Update an existing question
    @PutMapping("/{id}")
    public ResponseEntity<QuizQuestion> updateQuestion(@PathVariable Long id, @RequestBody QuizQuestion updatedQuestion) {
        QuizQuestion updated = questionService.updateQuestion(id, updatedQuestion);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // Delete a question by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestionById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
