package com.thoughtworks.guessnumber;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InputHandlerTest {
  InputHandler inputHandler;

  @Before
  public void setUp() {
    inputHandler = new InputHandler();
  }

  @Test
  public void should_return_output_object_contains_the_count_of_correct_numbers() {
    List<Integer> mockAnswer =
        new ArrayList<Integer>() {
          {
            add(1);
            add(5);
            add(6);
            add(7);
          }
        };

    OutputObject outputObject = inputHandler.handle("1 2 3 4", mockAnswer);

    assertEquals(1, outputObject.allRightNumberCount);
  }

  @Test
  public void should_return_output_object_contains_correct_numbers() {
    List<Integer> mockAnswer =
        new ArrayList<Integer>() {
          {
            add(1);
            add(5);
            add(6);
            add(7);
          }
        };
    List<Integer> allRightNumbers =
        new ArrayList<Integer>() {
          {
            add(1);
          }
        };

    OutputObject outputObject = inputHandler.handle("1 2 3 4", mockAnswer);

    assertEquals(allRightNumbers, outputObject.allRightNumbers);
  }

  @Test
  public void should_return_output_object_contains_the_count_of_wrong_position_numbers() {
    List<Integer> mockAnswer =
        new ArrayList<Integer>() {
          {
            add(1);
            add(4);
            add(3);
            add(2);
          }
        };

    OutputObject outputObject = inputHandler.handle("1 2 3 4", mockAnswer);

    assertEquals(2, outputObject.wrongPositionNumberCount);
  }
}
