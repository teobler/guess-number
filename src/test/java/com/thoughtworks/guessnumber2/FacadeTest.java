package com.thoughtworks.guessnumber2;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FacadeTest {
  Facade facade;

  @Before
  public void setUp() {
    facade = new Facade();
  }

  @Test
  public void should_map_input_numbers_from_string_to_string_list_split_by_space() {
    List<String> result = facade.mapInputToList("1 2 3 4");

    assertEquals(4, result.size());
    assertEquals("1", result.get(0));
    assertEquals("2", result.get(1));
    assertEquals("3", result.get(2));
    assertEquals("4", result.get(3));
  }

  @Test
  public void should_map_number_counts_to_string_output() {
    String result = facade.mapCountToOutput("1", "2");

    assertEquals("1A2B", result);
  }
}
