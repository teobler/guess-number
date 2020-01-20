package com.thoughtworks.guessnumber2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {

  private final String CORRECT_OUTPUT = "4A0B";
  private final int MAX_CHANCE_FOR_GUESSING = 6;
  private List<String> result = new ArrayList<>();
  private AnswerGenerator answerGenerator;
  private Referee referee;

  public GameController(AnswerGenerator answerGenerator, Referee referee) {
    this.answerGenerator = answerGenerator;
    this.referee = referee;
  }

  public void run() {
    Scanner input = new Scanner(System.in);

    for (int i = 0; i < MAX_CHANCE_FOR_GUESSING; i++) {
      if (input.hasNextLine()) {
        this.result.add(referee.judge(answerGenerator.generate(), input.nextLine()));
      }

      if (isLastResultCorrect()) {
        input.close();
        break;
      }
    }

    input.close();
  }

  private boolean isLastResultCorrect() {
    String lastResult = this.result.get(this.result.size() - 1);

    return CORRECT_OUTPUT.equals(lastResult);
  }

  public List<String> getResult() {
    return result;
  }
}
