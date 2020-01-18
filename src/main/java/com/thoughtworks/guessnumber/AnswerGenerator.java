package com.thoughtworks.guessnumber;

import java.util.ArrayList;
import java.util.List;

public class AnswerGenerator {
  public List<Integer> generate() {
    List<Integer> answer = new ArrayList<>();

    for(int i = 0; i < 4; i++) {
      answer.add((int) Math.round(Math.random()));
    }

    return answer;
  }
}
