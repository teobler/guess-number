package com.thoughtworks.guessnumber2;

import java.util.List;

public class Referee {
  Facade facade = new Facade();

  public String judge(List<String> answer, String inputStringNumber) {
    List<String> inputStringNumbers = facade.mapInputToList(inputStringNumber);

    String correctCount =
        String.valueOf(
            inputStringNumbers.stream()
                .filter(number -> answer.indexOf(number) == inputStringNumbers.indexOf(number))
                .count());
    String positionCorrectCount =
        String.valueOf(
            inputStringNumbers.stream()
                .filter(number -> answer.indexOf(number) != inputStringNumbers.indexOf(number))
                .filter(answer::contains)
                .count());

    return facade.mapCountToOutput(correctCount, positionCorrectCount);
  }
}
