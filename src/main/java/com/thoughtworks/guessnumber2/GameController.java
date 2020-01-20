package com.thoughtworks.guessnumber2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {

  private List<String> result = new ArrayList<>();
  private AnswerGenerator answerGenerator;
  private Referee referee;

  public GameController(AnswerGenerator answerGenerator, Referee referee) {
    this.answerGenerator = answerGenerator;
    this.referee = referee;
  }

  public void run() {
    Scanner input = new Scanner(System.in);

    for(int i = 0; i < 2; i++) {
      if (input.hasNextLine()) {
        String guessingNumber = input.nextLine();
        this.result.add(referee.judge(answerGenerator.generate(), guessingNumber));
      }
    }
  }

  public List<String> getResult() {
    return result;
  }
}
