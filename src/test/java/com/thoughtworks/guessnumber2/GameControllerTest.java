package com.thoughtworks.guessnumber2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameControllerTest {
  List<String> answer;

  @Before
  public void setUp() {
    answer = new ArrayList<String>() {{
      add("1");
      add("2");
      add("3");
      add("4");
    }};
  }

  @Test
  public void should_return_guessing_result_given_first_guessing() {
    String inputStringNumber = "1 5 6 7";
    Referee referee = mock(Referee.class);
    when(referee.judge(answer, inputStringNumber)).thenReturn("1A0B");
    GameController gameController = new GameController(referee);

    List<String> result = gameController.startNewRound(answer, inputStringNumber);

    assertEquals("1A0B", result.get(0));
  }

  @Test
  public void should_return_all_previous_result_given_wrong_guessing_twice() {
    String firstInputStringNumber = "1 5 6 7";
    String secondInputStringNumber = "1 2 6 7";
    List<String> inputStringNumbers = new ArrayList<String>() {{
      add(firstInputStringNumber);
      add(secondInputStringNumber);
    }};
    Referee referee = mock(Referee.class);
    when(referee.judge(answer, firstInputStringNumber)).thenReturn("1A0B");
    when(referee.judge(answer, secondInputStringNumber)).thenReturn("2A0B");
    GameController gameController = new GameController(referee);
    AtomicReference<List<String>> result = new AtomicReference<>();

    inputStringNumbers.forEach(numbers -> result.set(gameController.startNewRound(answer, numbers)));

    assertEquals(2, result.get().size());
    assertEquals("1A0B", result.get().get(0));
    assertEquals("2A0B", result.get().get(1));
  }
}
