package com.question.services.impl;

import com.question.entities.Question;
import com.question.repositories.QuestionRepository;
import com.question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionByQuestionId(Long questionId) {
        return questionRepository.findById(questionId).orElseThrow(() -> new RuntimeException("Question Not Found"));
    }

    @Override
    public List<Question> getQuestionsOfQuizByQuizId(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }
}
