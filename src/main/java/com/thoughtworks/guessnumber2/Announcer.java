package com.thoughtworks.guessnumber2;

import java.util.List;

public class Announcer {

  public void announcePreviousResults(List<String> previousResults) {
    previousResults.forEach(System.out::println);
  }
}
