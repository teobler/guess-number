package com.thoughtworks.guessnumber2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ValidatorTest {
  Validator validator;

  @Before
  public void setUp() {
    validator = new Validator();
  }

  @Test
  public void should_return_error_message_given_a_duplicate_number_input() {
    List<String> inputStringNumbers = new ArrayList<>();
    inputStringNumbers.add("1");
    inputStringNumbers.add("1");
    inputStringNumbers.add("2");
    inputStringNumbers.add("3");

    String errorMessage = validator.verify(inputStringNumbers);

    assertEquals("Wrong input, input again", errorMessage);
  }
}
