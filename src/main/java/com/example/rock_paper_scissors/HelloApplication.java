
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
    private TextField winner = new TextField();
    private Button playBt = new Button("PLAY!");

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
        gridPane.add(winner, 1, 2);
        gridPane.add(playBt, 1, 3);

        // Set properties for UI
        gridPane.setAlignment(Pos.CENTER);
        userSelection.setAlignment(Pos.BOTTOM_RIGHT);
        randomSelection.setAlignment(Pos.BOTTOM_RIGHT);
        winner.setAlignment(Pos.BOTTOM_RIGHT);
        playBt.setAlignment(Pos.BOTTOM_CENTER);
        randomSelection.setEditable(false);
        winner.setEditable(false);

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
        String userElection = getUserElection();
        String sysElection = randomElection();
        winner.setText(winner(sysElection, userElection));
        userSelection.setText(getUserElection());
        randomSelection.setText(sysElection);
    }

    private String getUserElection(){
        String input = userSelection.getText();
        String userElection;

        userElection = switch (input.toUpperCase()) {
            case "PAPER" -> "PAPER";
            case "ROCK" -> "ROCK";
            case "SCISSORS" -> "SCISSORS";
            default -> randomElection();
        };
        return userElection;
    }

    private static String randomElection() {
        String sysElection;
        sysElection = switch ((int) (Math.random() * 3)) {
            case 0 -> "PAPER";
            case 1 -> "SCISSORS";
            case 2 -> "ROCK";
            default -> "";
        };
        return sysElection;
    }

    public static String winner(String sysElection, String userElection) {
        String winner;
        winner = switch (sysElection){
            case "PAPER" -> paperBeats(userElection)?
                    "Computer" : userElection.equalsIgnoreCase("PAPER")?
                    "Tie" : "User";
            case "SCISSORS" -> scissorsBeats(userElection)?
                    "Computer ": userElection.equalsIgnoreCase("SCISSORS")?
                    "Tie" : "User";
            case "ROCK" -> rockBeats(userElection)?
                    "Computer" : userElection.equalsIgnoreCase("ROCK")?
                    "Tie" : "User";
            default -> "Tie";
        };
        return winner;
    }

    public static boolean paperBeats(String RPS) {
        return RPS.equalsIgnoreCase( "ROCK");
    }

    public static boolean scissorsBeats(String RPS) {
        return RPS.equalsIgnoreCase( "PAPER");
    }

    public static boolean rockBeats(String RPS) {
        return RPS.equalsIgnoreCase("SCISSORS");
    }
}