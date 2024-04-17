package com.course2.homeWork.service;

import com.course2.homeWork.exception.QuestionNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static com.course2.homeWork.service.TestConstants.*;

import static org.assertj.core.api.Assertions.*;

class JavaQuestionServiceTest {
    private final QuestionService questionService = new JavaQuestionService();
    private final int MOCK_QUESTION_SIZE = 3;
    @BeforeEach
    public void beforeEach() {
        questionService.add(QUESTION_1);
        questionService.add(QUESTION_2);
        questionService.add(QUESTION_3);
    }


    @Test
    void addTest() {
        int beforeCount = questionService.getAll().size();
      assertThat(questionService.add(QUESTION_4))
                .isEqualTo(QUESTION_4)
                .isIn(questionService.getAll());
        assertThat(questionService.getAll()).hasSize(beforeCount + 1);
    }



    @Test
    void removeTest() {
        int beforeCount = questionService.getAll().size();
        assertThat(questionService.remove(QUESTION_1))
                .isEqualTo(QUESTION_1)
                .isNotIn(questionService.getAll());
        assertThat(questionService.getAll()).hasSize(beforeCount -1);
    }

    @Test
    void questionNotFoundExceptionTest() {
        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> questionService.remove(QUESTION_5));
    }

    @Test
    void getAllTest() {
        assertThat(questionService.getAll())
                .hasSize(MOCK_QUESTION_SIZE)
                .containsExactlyInAnyOrder(
                        QUESTION_1,
                        QUESTION_2,
                        QUESTION_3
                );
    }

    @Test
    void getRandomQuestionTest() {
        assertThat(questionService.getRandomQuestion())
                .isNotNull()
                .isIn(questionService.getAll());


    }
}