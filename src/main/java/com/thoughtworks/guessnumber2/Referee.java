package com.thoughtworks.guessnumber2;

import java.util.List;

public class Referee {
  Facade facade = new Facade();

  public String judge(String input, List<String> answer) {
    List<String> inputNumbers = facade.mapInputToList(input);
    String positionCorrectCount = String.valueOf(inputNumbers.stream().filter(answer::contains).count());
    return "0A" + positionCorrectCount + "B";
  }
}
