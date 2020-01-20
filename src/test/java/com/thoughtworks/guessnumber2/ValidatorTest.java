package com.thoughtworks.guessnumber2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidatorTest {
  Validator validator;

  @Before
  public void setUp() {
    validator = new Validator();
  }

  @Test
  public void should_return_error_message_given_a_duplicate_number_input() {
    String inputStringNumber = "1 1 2 3";

    String errorMessage = validator.verify(inputStringNumber);

    assertEquals("Wrong input, input again", errorMessage);
  }

  @Test
  public void should_return_error_message_given_a_input_but_length_not_4() {
    String inputStringNumber = "1 3 2";

    String errorMessage = validator.verify(inputStringNumber);

    assertEquals("Wrong input, input again", errorMessage);
  }
}
