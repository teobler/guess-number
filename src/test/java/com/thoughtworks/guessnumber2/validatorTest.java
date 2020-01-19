package com.thoughtworks.guessnumber2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class validatorTest {
  Validator validator;

  @Before
  public void setUp() {
    validator = new Validator();
  }

  @Test
  public void should_return_0A0B_given_guess_numbers_match_nothing() {
    String result = validator.validate("5 6 7 8");

    assertEquals(result, "0A0B");
  }
}
