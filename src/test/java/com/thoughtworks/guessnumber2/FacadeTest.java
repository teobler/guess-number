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

    assertEquals(result.size(), 4);
    assertEquals(result.get(0), "1");
    assertEquals(result.get(1), "2");
    assertEquals(result.get(2), "3");
    assertEquals(result.get(3), "4");
  }
}