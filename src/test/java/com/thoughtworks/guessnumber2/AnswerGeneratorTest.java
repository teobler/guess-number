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
    List<String> answer = answerGenerator.generate();

    assertEquals(4, answer.size());
  }

  @Test
  public void answer_number_should_between_0_and_9() {
    List<String> answer = answerGenerator.generate();

    answer.forEach(stringNumber -> {
      assertTrue(Integer.parseInt(stringNumber) >= 0);
      assertTrue(Integer.parseInt(stringNumber) <= 9);
    });
  }

  @Test
  public void answer_number_should_different_with_each_other() {
    List<String> answer = answerGenerator.generate();

    assertTrue(answer.stream().allMatch(new HashSet<>()::add));
  }
}
