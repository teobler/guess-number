package com.thoughtworks.guessnumber2;

import java.util.List;

public class Announcer {

  public void announcePreviousResults(List<String> previousResults) {
    previousResults.forEach(System.out::println);
  }

  public void congratulations() {
    System.out.println("Congratulations, you win !");
  }

  public void announceError(String errorMessage) {
    System.out.println(errorMessage);
  }
}
