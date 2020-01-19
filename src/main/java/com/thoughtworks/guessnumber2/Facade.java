package com.thoughtworks.guessnumber2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Facade {
  public List<String> mapInputToList(String inputNumbers) {
    return Arrays.stream(inputNumbers.split(" ")).collect(Collectors.toList());
  }
}
