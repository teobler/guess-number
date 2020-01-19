package com.thoughtworks.guessnumber2;

import java.util.List;

public class Referee {
  Facade facade = new Facade();

  public String judge(String input, List<String> answer) {
    List<String> inputNumbers = facade.mapInputToList(input);
    String correctCount =
        String.valueOf(
            inputNumbers.stream()
                .filter(number -> answer.indexOf(number) == inputNumbers.indexOf(number))
                .count());
    String positionCorrectCount =
        String.valueOf(
            inputNumbers.stream()
                .filter(number -> answer.indexOf(number) != inputNumbers.indexOf(number))
                .filter(answer::contains)
                .count());
    return correctCount + "A" + positionCorrectCount + "B";
  }
}
