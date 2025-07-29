package com.quiz.controllers;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;


    @PostMapping("/")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        Quiz addedQuiz = quizService.addQuiz(quiz);
        return new ResponseEntity<>(addedQuiz, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Quiz>> getAllQuiz() {
        List<Quiz> quizList = quizService.getAllQuiz();
        return ResponseEntity.ok(quizList);
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getQuizByQuizId(@PathVariable Long quizId) {
        Quiz quiz = quizService.getQuizByQuizId(quizId);
        return ResponseEntity.ok(quiz);
    }


}
