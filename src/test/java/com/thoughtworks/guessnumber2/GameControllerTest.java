package com.thoughtworks.guessnumber2;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
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
  public void should_return_just_one_result_given_just_one_wrong_guessing() {
    String input = "1 5 6 7";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
    when(answerGenerator.generate()).thenReturn(answer);
    Referee referee = mock(Referee.class);
    when(referee.judge(answer, input)).thenReturn("1A0B");
    GameController gameController = new GameController(answerGenerator, referee);

    gameController.run();

    assertEquals("1A0B", gameController.getResult());
  }
}
