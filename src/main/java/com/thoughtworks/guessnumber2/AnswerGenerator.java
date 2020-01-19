package com.thoughtworks.guessnumber2;

import java.util.ArrayList;
import java.util.List;

public class AnswerGenerator {

  public List<Integer> generate() {
    return new ArrayList<Integer>() {{
      add(1);
      add(2);
      add(3);
      add(4);
    }};
  }
}
