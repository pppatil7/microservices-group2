package com.question.controllers;

import com.question.entities.Question;
import com.question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        Question addedQuestion = questionService.addQuestion(question);
        return new ResponseEntity<>(addedQuestion, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Question>> getAllQuestion() {
        List<Question> questionList = questionService.getAllQuestion();
        return ResponseEntity.ok(questionList);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<Question> getQuestionByQuestionId(@PathVariable Long questionId) {
        Question question = questionService.getQuestionByQuestionId(questionId);
        return ResponseEntity.ok(question);
    }


}
