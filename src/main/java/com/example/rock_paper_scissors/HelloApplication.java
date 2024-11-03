
package com.example.rock_paper_scissors;

import com.example.rock_paper_scissors.GamePane.GamePane;
import javafx.application.Application;
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
    private Button playBt = new Button("PLAY!");

    @Override
    public void start(Stage stage) {

        GamePane gamePane = new GamePane();

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
        gridPane.add(new Label("Random selection: "), 0, 1);
        gridPane.add(randomSelection, 1,1);

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
}