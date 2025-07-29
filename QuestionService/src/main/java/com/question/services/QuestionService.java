package com.question.services;

import com.question.entities.Question;

import java.util.List;

public interface QuestionService {

    Question addQuestion(Question question);

    List<Question> getAllQuestion();

    Question getQuestionByQuestionId(Long questionId);

}
