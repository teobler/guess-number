package com.thoughtworks.guessnumber2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RefereeTest {
  Referee referee;

  @Before
  public void setUp() {
    referee = new Referee();
  }

  @Test
  public void should_return_0A0B_given_guess_numbers_match_nothing() {
    List<String> answer = new ArrayList<String>() {{
      add("1");
      add("2");
      add("3");
      add("4");
    }};
    String result = referee.judge("5 6 7 8", answer);

    assertEquals("0A0B", result);
  }

  @Test
  public void should_return_0A1B_given_guess_numbers_match_1_correct_number_without_position() {
    List<String> answer = new ArrayList<String>() {{
      add("1");
      add("2");
      add("3");
      add("4");
    }};
    ArrayList<String> inputNumbers = new ArrayList<String>() {{
      add("2");
      add("6");
      add("7");
      add("8");
    }};
    Facade facade = mock(Facade.class);
    when(facade.mapInputToList("2 6 7 8")).thenReturn(inputNumbers);

    String result = referee.judge("2 6 7 8", answer);

    assertEquals("0A1B", result);
  }

  @Test
  public void should_return_1A0B_given_guess_numbers_match_1_correct_number() {
    List<String> answer = new ArrayList<String>() {{
      add("1");
      add("2");
      add("3");
      add("4");
    }};
    ArrayList<String> inputNumbers = new ArrayList<String>() {{
      add("1");
      add("6");
      add("7");
      add("8");
    }};
    Facade facade = mock(Facade.class);
    when(facade.mapInputToList("1 6 7 8")).thenReturn(inputNumbers);

    String result = referee.judge("1 6 7 8", answer);

    assertEquals("1A0B", result);
  }

  @Test
  public void should_return_1A1B_given_guess_numbers_match_1_correct_number_and_1_correct_number_without_position() {
    List<String> answer = new ArrayList<String>() {{
      add("1");
      add("2");
      add("3");
      add("4");
    }};
    ArrayList<String> inputNumbers = new ArrayList<String>() {{
      add("1");
      add("6");
      add("4");
      add("8");
    }};
    Facade facade = mock(Facade.class);
    when(facade.mapInputToList("1 6 4 8")).thenReturn(inputNumbers);

    String result = referee.judge("1 6 4 8", answer);

    assertEquals("1A1B", result);
  }

  @Test
  public void should_return_2A0B_given_guess_numbers_match_2_correct_numbers() {
    List<String> answer = new ArrayList<String>() {{
      add("1");
      add("2");
      add("3");
      add("4");
    }};
    ArrayList<String> inputNumbers = new ArrayList<String>() {{
      add("1");
      add("2");
      add("7");
      add("8");
    }};
    Facade facade = mock(Facade.class);
    when(facade.mapInputToList("1 2 7 8")).thenReturn(inputNumbers);

    String result = referee.judge("1 2 7 8", answer);

    assertEquals("2A0B", result);
  }
}
