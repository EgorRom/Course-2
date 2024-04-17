package com.course2.homeWork.service;

import com.course2.homeWork.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String questions, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

}
