package com.thoughtworks.guessnumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {
  OutputObject outputObject = new OutputObject();

  public OutputObject handle(String input, List<Integer> answer) {
    List<Integer> inputNumbers = formatInputStringAsIntList(input);

    List<Integer> restNumbers = handleCorrectNumbers(answer, inputNumbers);
    handleWrongPositionNumbers(answer, restNumbers);

    return this.outputObject;
  }

  private List<Integer> formatInputStringAsIntList(String input) {
    return Arrays
        .stream(input.split(" "))
        .mapToInt(Integer::new)
        .boxed()
        .collect(Collectors.toList());
  }

  private List<Integer> handleCorrectNumbers(List<Integer> answer, List<Integer> inputNumbers) {
    List<Integer> restNumbers = new ArrayList<>(inputNumbers);

    for (int i = 0; i < inputNumbers.size(); i++) {
      if (inputNumbers.get(i).equals(answer.get(i))) {
        this.outputObject.allRightNumberCount++;
        this.outputObject.allRightNumbers.add(inputNumbers.get(i));
        restNumbers.remove(inputNumbers.get(i));
      }
    }

    return restNumbers;
  }

  private void handleWrongPositionNumbers(List<Integer> answer, List<Integer> restNumbers) {
    restNumbers.forEach(number -> {
      if (answer.contains(number)) {
        this.outputObject.wrongPositionNumberCount++;
        this.outputObject.wrongPositionNumbers.add(number);
      }
    });
  }
}
