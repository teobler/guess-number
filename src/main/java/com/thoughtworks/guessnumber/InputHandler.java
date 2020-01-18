package com.thoughtworks.guessnumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {

  public OutputObject handle(String input, List<Integer> answer) {
    List<Integer> inputNumbers = Arrays
        .stream(input.split(" "))
        .mapToInt(Integer::new)
        .boxed()
        .collect(Collectors.toList());
    OutputObject outputObject = new OutputObject();

    for (int i = 0; i < inputNumbers.size(); i++) {
      if (inputNumbers.get(i).equals(answer.get(i))) {
        outputObject.allRightNumber++;
      }
    }

    return outputObject;
  }
}
