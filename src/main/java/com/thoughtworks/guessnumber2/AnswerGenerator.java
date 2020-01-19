package com.thoughtworks.guessnumber2;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class AnswerGenerator {

  public List<String> generate() {
    int MIN_ANSWER = 0;
    int MAX_ANSWER = 9;
    int ANSWER_SIZE = 4;

    return ThreadLocalRandom.current()
        .ints(MIN_ANSWER, MAX_ANSWER)
        .distinct()
        .limit(ANSWER_SIZE)
        .boxed()
        .map(String::valueOf)
        .collect(Collectors.toList());
  }
}
