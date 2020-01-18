package com.thoughtworks.guessnumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {
  OutputObject outputObject = new OutputObject();

  public OutputObject handle(String input, List<Integer> answer) {
    List<Integer> inputNumbers = formatInputStringAsIntList(input);

    handlePositionAndNumberAllRight(answer, inputNumbers);

    return this.outputObject;
  }

  private List<Integer> formatInputStringAsIntList(String input) {
    return Arrays
        .stream(input.split(" "))
        .mapToInt(Integer::new)
        .boxed()
        .collect(Collectors.toList());
  }

  private void handlePositionAndNumberAllRight(List<Integer> answer, List<Integer> inputNumbers) {
    for (int i = 0; i < inputNumbers.size(); i++) {
      if (inputNumbers.get(i).equals(answer.get(i))) {
        this.outputObject.allRightNumberCount++;
        this.outputObject.allRightNumbers.add(inputNumbers.get(i));
      }
    }
  }
}
