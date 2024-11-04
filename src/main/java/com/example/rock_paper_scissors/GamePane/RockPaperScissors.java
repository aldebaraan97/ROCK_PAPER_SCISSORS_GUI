package com.example.rock_paper_scissors.GamePane;

import java.util.Scanner;

public class RockPaperScissors {

    public RockPaperScissors() {
    }

    public static String userElection(String input) {
        String userElection;
        userElection = switch (input.toUpperCase()) {
            case "PAPER" -> "PAPER";
            case "ROCK" -> "ROCK";
            case "SCISSORS" -> "SCISSORS";
            default -> randomElection();
        };
        return userElection;
    }

    public static String randomElection() {
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
