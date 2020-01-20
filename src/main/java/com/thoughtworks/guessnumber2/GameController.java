package com.thoughtworks.guessnumber2;

import java.util.ArrayList;
import java.util.List;

public class GameController {
  Referee referee;
  List<String> result = new ArrayList<>();

  public GameController(Referee referee) {
    this.referee = referee;
  }

  public List<String> startNewRound(List<String> answer, String inputNumber) {
    result.add(referee.judge(answer, inputNumber));

    return this.result;
  }
}
