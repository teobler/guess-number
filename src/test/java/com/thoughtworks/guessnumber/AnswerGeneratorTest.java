package com.thoughtworks.guessnumber;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnswerGeneratorTest {
  AnswerGenerator answerGenerator;

  @Before
  public void setUp() {
    answerGenerator = new AnswerGenerator();
  }

  @Test
  public void should_return_a_list_contains_4_numbers() {
    List<Integer> answer = answerGenerator.generate();

    assertEquals(4, answer.size());
  }

  @Test
  public void all_numbers_should_between_0_9() {
    List<Integer> answer = answerGenerator.generate();

    answer.forEach(
        number -> {
          assertTrue(number >= 0);
          assertTrue(number <= 9);
        });
  }
}
