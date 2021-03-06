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
  private Validator validator;
  private Announcer announcer;

  public GameController(
      AnswerGenerator answerGenerator, Referee referee, Validator validator, Announcer announcer) {
    this.answerGenerator = answerGenerator;
    this.referee = referee;
    this.validator = validator;
    this.announcer = announcer;
  }

  public void run() {
    List<String> answer = answerGenerator.generate();
    Scanner input = new Scanner(System.in);

    for (int i = 0; i < MAX_CHANCE_FOR_GUESSING; i++) {
      if (input.hasNextLine()) {
        String nextLine = input.nextLine();
        if (isInputInvalid(nextLine)) {
          announcer.announceError(validator.verify(nextLine));
          continue;
        }

        this.result.add(referee.judge(answer, nextLine));
        announcer.announcePreviousResults(this.result);
      }

      if (isResultHasValue() && isLastResultCorrect()) {
        announcer.congratulations();
        input.close();
        break;
      }
    }

    input.close();
  }

  private boolean isInputInvalid(String nextLine) {
    return validator.verify(nextLine) != null;
  }

  private boolean isResultHasValue() {
    return this.result.size() != 0;
  }

  private boolean isLastResultCorrect() {
    String lastResult = this.result.get(this.result.size() - 1);

    return CORRECT_OUTPUT.equals(lastResult);
  }

  public List<String> getResult() {
    return result;
  }
}
