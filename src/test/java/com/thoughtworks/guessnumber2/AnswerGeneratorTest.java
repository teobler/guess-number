package com.thoughtworks.guessnumber2;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

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
  public void answer_number_should_between_0_and_9() {
    List<Integer> answer = answerGenerator.generate();

    answer.forEach(number -> {
      assertTrue(number >= 0);
      assertTrue(number <= 9);
    });
  }

  @Test
  public void answer_number_should_different_with_each_other() {
    List<Integer> answer = answerGenerator.generate();

    assertTrue(answer.stream().allMatch(new HashSet<>()::add));
  }
}
