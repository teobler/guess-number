package com.thoughtworks.guessnumber2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Validator {

  public String verify(String inputStringNumber) {
    int distinctCount =
        Arrays.stream(inputStringNumber.split(" "))
            .collect(Collectors.toSet())
            .size();

    if (distinctCount == 4) {
      return null;
    }

    return "Wrong input, input again";
  }
}
