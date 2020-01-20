package com.thoughtworks.guessnumber2;

import java.util.Scanner;

public class GameController {

  private String result;
  private AnswerGenerator answerGenerator;
  private Referee referee;

  public GameController(AnswerGenerator answerGenerator, Referee referee) {
    this.answerGenerator = answerGenerator;
    this.referee = referee;
  }

  public String getResult() {
    return result;
  }

  public void run() {
    Scanner input = new Scanner(System.in);

    String guessingNumber = input.nextLine();

    this.result = referee.judge(answerGenerator.generate(), guessingNumber);
  }
}
