
package com.example.rock_paper_scissors;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private TextField userSelection = new TextField();
    private TextField randomSelection = new TextField();
    private TextField winnerText = new TextField();
    private Button playBt = new Button("PLAY!");
    private RockPaperScissorsLogic gameLogic = new RockPaperScissorsLogic();

    @Override
    public void start(Stage stage) {
        // Introduction label
        String introduction = """
                Program to play ROCK, PAPER, SCISSORS game against the computer.
                Enter only 'ROCK', 'PAPER' or 'SCISSORS' (case insensitive).
                Any other input will assign the user a random choice.""";

        // Create UI for game
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(new Label("Type your selection:"), 0, 0);
        gridPane.add(userSelection, 1, 0);
        gridPane.add(new Label("Computer selection: "), 0, 1);
        gridPane.add(randomSelection, 1,1);
        gridPane.add(new Label("Winner"), 0, 2);
        gridPane.add(winnerText, 1, 2);
        gridPane.add(playBt, 1, 3);

        // Set properties for UI
        gridPane.setAlignment(Pos.CENTER);
        userSelection.setAlignment(Pos.BOTTOM_RIGHT);
        randomSelection.setAlignment(Pos.BOTTOM_RIGHT);
        winnerText.setAlignment(Pos.BOTTOM_RIGHT);
        playBt.setAlignment(Pos.BOTTOM_CENTER);
        randomSelection.setEditable(false);
        winnerText.setEditable(false);

        // Process events
        playBt.setOnAction(e -> playGame());

        // Place introduction and text fields in border pane
        BorderPane pane = new BorderPane();
        pane.setTop(new Label(introduction));
        pane.setCenter(gridPane);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 250);
        stage.setTitle("ROCK,PAPER,SCISSORS!"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show();
    }

    public void playGame() {
        // Get values from text fields
        String winner;
        gameLogic.setSysElection();
        String sysElection = gameLogic.getSysElection();
        String userInput = userSelection.getText();
        gameLogic.setUserElection(userInput);
        String userElection = gameLogic.getUserElection();

        gameLogic.setWinner(sysElection, userElection);
        winner = gameLogic.getWinner();

        userSelection.setText(gameLogic.getUserElection());
        randomSelection.setText(sysElection);
        winnerText.setText(winner);
    }
}