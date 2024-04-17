package com.course2.homeWork.service;

import com.course2.homeWork.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
