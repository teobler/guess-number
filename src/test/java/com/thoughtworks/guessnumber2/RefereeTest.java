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
  List<String> answer;

  @Before
  public void setUp() {
    referee = new Referee();
    answer = new ArrayList<String>() {{
      add("1");
      add("2");
      add("3");
      add("4");
    }};
  }

  @Test
  public void should_return_0A0B_given_guess_numbers_match_nothing() {
    String result = referee.judge(answer, "5 6 7 8");

    assertEquals("0A0B", result);
  }

  @Test
  public void should_return_0A1B_given_guess_numbers_match_1_correct_number_without_position() {
    ArrayList<String> inputNumbers = new ArrayList<String>() {{
      add("2");
      add("6");
      add("7");
      add("8");
    }};
    Facade facade = mock(Facade.class);
    when(facade.mapInputToList("2 6 7 8")).thenReturn(inputNumbers);

    String result = referee.judge(answer, "2 6 7 8");

    assertEquals("0A1B", result);
  }

  @Test
  public void should_return_1A0B_given_guess_numbers_match_1_correct_number() {
    ArrayList<String> inputNumbers = new ArrayList<String>() {{
      add("1");
      add("6");
      add("7");
      add("8");
    }};
    Facade facade = mock(Facade.class);
    when(facade.mapInputToList("1 6 7 8")).thenReturn(inputNumbers);

    String result = referee.judge(answer, "1 6 7 8");

    assertEquals("1A0B", result);
  }

  @Test
  public void should_return_1A1B_given_guess_numbers_match_1_correct_number_and_1_correct_number_without_position() {
    ArrayList<String> inputNumbers = new ArrayList<String>() {{
      add("1");
      add("6");
      add("4");
      add("8");
    }};
    Facade facade = mock(Facade.class);
    when(facade.mapInputToList("1 6 4 8")).thenReturn(inputNumbers);

    String result = referee.judge(answer, "1 6 4 8");

    assertEquals("1A1B", result);
  }

  @Test
  public void should_return_2A0B_given_guess_numbers_match_2_correct_numbers() {
    ArrayList<String> inputNumbers = new ArrayList<String>() {{
      add("1");
      add("2");
      add("7");
      add("8");
    }};
    Facade facade = mock(Facade.class);
    when(facade.mapInputToList("1 2 7 8")).thenReturn(inputNumbers);

    String result = referee.judge(answer, "1 2 7 8");

    assertEquals("2A0B", result);
  }

  @Test
  public void should_return_0A2B_given_guess_numbers_match_2_correct_numbers_without_position() {
    ArrayList<String> inputNumbers = new ArrayList<String>() {{
      add("2");
      add("7");
      add("1");
      add("8");
    }};
    Facade facade = mock(Facade.class);
    when(facade.mapInputToList("2 7 1 8")).thenReturn(inputNumbers);

    String result = referee.judge(answer, "2 7 1 8");

    assertEquals("0A2B", result);
  }

  @Test
  public void should_return_4A0B_given_guess_numbers_match_4_correct_numbers() {
    ArrayList<String> inputNumbers = new ArrayList<String>() {{
      add("1");
      add("2");
      add("3");
      add("4");
    }};
    Facade facade = mock(Facade.class);
    when(facade.mapInputToList("1 2 3 4")).thenReturn(inputNumbers);

    String result = referee.judge(answer, "1 2 3 4");

    assertEquals("4A0B", result);
  }

  @Test
  public void should_return_0A4B_given_guess_numbers_match_4_correct_numbers_without_position() {
    ArrayList<String> inputNumbers = new ArrayList<String>() {{
      add("2");
      add("1");
      add("4");
      add("3");
    }};
    Facade facade = mock(Facade.class);
    when(facade.mapInputToList("2 1 4 3")).thenReturn(inputNumbers);

    String result = referee.judge(answer, "2 1 4 3");

    assertEquals("0A4B", result);
  }
}
