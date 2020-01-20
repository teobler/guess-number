package com.thoughtworks.guessnumber2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnnouncerTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  Announcer announcer;

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    announcer = new Announcer();
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  @Test
  public void should_print_previous_results() {
    List<String> previousResults = new ArrayList<>();
    previousResults.add("1A0B");
    previousResults.add("2A1B");
    previousResults.add("3A0B");

    announcer.announcePreviousResults(previousResults);

    assertEquals("1A0B\n2A1B\n3A0B\n", outContent.toString());
  }

  @Test
  public void should_print_congratulations_information() {
    announcer.congratulations();

    assertEquals("Congratulations, you win !", outContent.toString());
  }

  @Test
  public void should_print_error_message() {
    announcer.announceError("Wrong input, input again");

    assertEquals("Wrong input, input again", outContent.toString());
  }
}
