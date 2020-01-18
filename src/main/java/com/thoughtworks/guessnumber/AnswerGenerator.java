package com.thoughtworks.guessnumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnswerGenerator {
  public List<Integer> generate() {
    List<Integer> answer = new ArrayList<>();
    Random random = new Random();

    for(int i = 0; i < 4; i++) {
      answer.add(random.nextInt(10));
    }

    return answer;
  }
}
