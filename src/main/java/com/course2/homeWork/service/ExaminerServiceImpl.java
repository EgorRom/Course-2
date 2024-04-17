package com.course2.homeWork.service;

import com.course2.homeWork.exception.IncorrectQuestionAmountException;
import com.course2.homeWork.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > questionService.getAll().size()) {
            throw new IncorrectQuestionAmountException();
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size()<amount){
            questions.add(questionService.getRandomQuestion());
        }

        return questions;
    }
}
