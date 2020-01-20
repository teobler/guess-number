package com.thoughtworks.guessnumber2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameControllerTest {
  @Test
  public void should_return_guessing_result_given_first_guessing() {
    List<String> answer = new ArrayList<String>() {{
      add("1");
      add("2");
      add("3");
      add("4");
    }};
    String inputStringNumber = "1 5 6 7";
    Referee referee = mock(Referee.class);
    when(referee.judge(answer, inputStringNumber)).thenReturn("1A0B");
    GameController gameController = new GameController(referee);

    String result = gameController.startNewRound(answer, inputStringNumber);

    assertEquals("1A0B", result);
  }
}
