package com.thoughtworks.guessnumber2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class GameControllerTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  List<String> answer;
  AnswerGenerator answerGenerator;
  Referee referee;
  Validator validator;
  Announcer announcer;

  @Before
  public void setUp() {
    answer = new ArrayList<String>() {{
      add("1");
      add("2");
      add("3");
      add("4");
    }};
    answerGenerator = mock(AnswerGenerator.class);
    referee = mock(Referee.class);
    validator = mock(Validator.class);
    announcer = mock(Announcer.class);
    System.setOut(new PrintStream(outContent));
    announcer = new Announcer();
  }

  @After
  public void tearDown() {
    System.setOut(originalOut);
  }

  @Test
  public void should_return_just_one_result_given_just_one_wrong_guessing() {
    String input = "1 5 6 7";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    when(answerGenerator.generate()).thenReturn(answer);
    when(referee.judge(answer, input)).thenReturn("1A0B");
    GameController gameController = new GameController(answerGenerator, referee, validator, announcer);

    gameController.run();

    assertEquals("1A0B", gameController.getResult().get(0));
  }

  @Test
  public void should_return_just_one_result_given_just_one_correct_guessing() {
    String input = "1 2 3 4";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    when(answerGenerator.generate()).thenReturn(answer);
    when(referee.judge(answer, input)).thenReturn("4A0B");
    GameController gameController = new GameController(answerGenerator, referee, validator, announcer);

    gameController.run();

    assertEquals("4A0B", gameController.getResult().get(0));
  }

  @Test
  public void should_return_two_results_given_two_wrong_guessing() {
    String input = "1 5 6 7\n1 3 6 7";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    when(answerGenerator.generate()).thenReturn(answer);
    when(referee.judge(answer, "1 5 6 7")).thenReturn("1A0B");
    when(referee.judge(answer, "1 3 6 7")).thenReturn("1A1B");
    GameController gameController = new GameController(answerGenerator, referee, validator, announcer);

    gameController.run();

    assertEquals("1A0B", gameController.getResult().get(0));
    assertEquals("1A1B", gameController.getResult().get(1));
  }

  @Test
  public void should_return_just_one_results_given_one_correct_guessing_and_one_wrong_guessing() {
    String input = "1 2 3 4\n1 3 6 7";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    when(answerGenerator.generate()).thenReturn(answer);
    when(referee.judge(answer, "1 2 3 4")).thenReturn("4A0B");
    when(referee.judge(answer, "1 3 6 7")).thenReturn("1A1B");
    GameController gameController = new GameController(answerGenerator, referee, validator, announcer);

    gameController.run();

    assertEquals(1, gameController.getResult().size());
    assertEquals("4A0B", gameController.getResult().get(0));
  }

  @Test
  public void should_return_six_results_given_six_wrong_guessing() {
    String input = "1 3 6 7\n1 3 6 7\n1 3 6 7\n1 3 6 7\n1 3 6 7\n1 3 6 7";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    when(answerGenerator.generate()).thenReturn(answer);
    when(referee.judge(answer, "1 3 6 7")).thenReturn("1A1B");
    GameController gameController = new GameController(answerGenerator, referee, validator, announcer);

    gameController.run();

    assertEquals(6, gameController.getResult().size());
    assertEquals("1A1B", gameController.getResult().get(0));
    assertEquals("1A1B", gameController.getResult().get(5));
  }

  @Test
  public void should_return_six_results_given_seven_wrong_guessing() {
    String input = "1 3 6 7\n1 3 6 7\n1 3 6 7\n1 3 6 7\n1 3 6 7\n1 3 6 7\n1 3 6 7";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    when(answerGenerator.generate()).thenReturn(answer);
    when(referee.judge(answer, "1 3 6 7")).thenReturn("1A1B");
    GameController gameController = new GameController(answerGenerator, referee, validator, announcer);

    gameController.run();

    assertEquals(6, gameController.getResult().size());
    assertEquals("1A1B", gameController.getResult().get(0));
    assertEquals("1A1B", gameController.getResult().get(5));
  }

  @Test
  public void should_return_two_results_given_one_wrong_guessing_one_correct_guessing_and_one_wrong_guessing() {
    String input = "1 3 6 7\n1 2 3 4\n1 3 6 7";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    when(answerGenerator.generate()).thenReturn(answer);
    when(referee.judge(answer, "1 3 6 7")).thenReturn("1A1B");
    when(referee.judge(answer, "1 2 3 4")).thenReturn("4A0B");
    GameController gameController = new GameController(answerGenerator, referee, validator, announcer);

    gameController.run();

    assertEquals(2, gameController.getResult().size());
    assertEquals("1A1B", gameController.getResult().get(0));
    assertEquals("4A0B", gameController.getResult().get(1));
  }

  @Test
  public void should_print_wrong_input_input_again_given_a_invalid_input() {
    String input = "1 3 6";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    when(validator.verify(input)).thenReturn("Wrong input, input again");
    GameController gameController = new GameController(answerGenerator, referee, validator, announcer);

    gameController.run();

    assertEquals(0, gameController.getResult().size());
    assertEquals("Wrong input, input again\n", outContent.toString());
  }

  @Test
  public void should_print_congratulations_given_correct_guessing() {
    String input = "1 2 3 4";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    when(validator.verify(input)).thenReturn(null);
    when(answerGenerator.generate()).thenReturn(answer);
    when(referee.judge(answer, input)).thenReturn("4A0B");
    GameController gameController = new GameController(answerGenerator, referee, validator, announcer);

    gameController.run();

    assertEquals(1, gameController.getResult().size());
    assertEquals("4A0B", gameController.getResult().get(0));
    assertEquals("Congratulations, you win !\n", outContent.toString());
  }
}
