package com.course2.homeWork.service;

import com.course2.homeWork.exception.IncorrectQuestionAmountException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.course2.homeWork.service.TestConstants.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void shouldThrowIncorrectQuestionAmountException() {
        when(questionService.getAll()).thenReturn(MOK_QUESTIONS);
        assertThatExceptionOfType(IncorrectQuestionAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(-1));
        assertThatExceptionOfType(IncorrectQuestionAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(MOK_QUESTIONS.size()+1));


    }

    @Test
    void getRandomQuestionsTest() {
        when(questionService.getAll()).thenReturn(MOK_QUESTIONS);
        when(questionService.getRandomQuestion()).thenReturn(
                QUESTION_1,
                QUESTION_2,
                QUESTION_3,
                QUESTION_4
        );
        int questionAmount = MOK_QUESTIONS.size() - 2;
        assertThat(examinerService.getQuestions(questionAmount))
                .hasSize(questionAmount);

    }
}