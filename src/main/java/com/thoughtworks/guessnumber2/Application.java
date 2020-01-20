package com.thoughtworks.guessnumber2;

public class Application {
  public static void main(String[] args) {
    GameController gameController =
        new GameController(new AnswerGenerator(), new Referee(), new Validator(), new Announcer());

    gameController.run();
  }
}
