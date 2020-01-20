package com.thoughtworks.guessnumber2;

import java.util.List;


public class GameController {
  Referee referee;

  public GameController(Referee referee) {
    this.referee = referee;
  }

  public String startNewRound(List<String> answer, String inputNumber) {
    return this.referee.judge(answer, inputNumber);
  }
}
