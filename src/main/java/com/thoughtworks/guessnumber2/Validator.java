package com.thoughtworks.guessnumber2;

import java.util.List;

public class Validator {

  public String verify(List<String> inputStringNumber) {
    long distinctNumber = inputStringNumber.stream().distinct().count();

    if (distinctNumber != 4) {
      return "Wrong input, input again";
    }

    return null;
  }
}
