package com.thoughtworks.guessnumber2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RefereeTest {
  Referee referee;

  @Before
  public void setUp() {
    referee = new Referee();
  }

  @Test
  public void should_return_0A0B_given_guess_numbers_match_nothing() {
    String result = referee.judge("5 6 7 8");

    assertEquals(result, "0A0B");
  }
}
