package com.thoughtworks.guessnumber;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

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
}
