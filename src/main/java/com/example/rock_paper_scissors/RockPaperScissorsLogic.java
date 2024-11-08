package com.example.rock_paper_scissors;

public class RockPaperScissorsLogic {
    private String userElection;
    private String sysElection;
    private String winner;

    /** Construct a game logic */
    public RockPaperScissorsLogic() {
    }

    /** Get user election */
    public String  getUserElection(){
        return userElection;
    }

    /** Set user election */ // you need to capture this result
    public void setUserElection(String userInput){
        this.userElection = switch (userInput.toUpperCase()) {
            case "PAPER" -> "PAPER";
            case "ROCK" -> "ROCK";
            case "SCISSORS" -> "SCISSORS";
            default -> getRandomElection();
        };
    }

    /** Get system election */
    public String getSysElection() {
        return sysElection;
    }

    /** Set a new system election */
    public void setSysElection() {
        this.sysElection = getRandomElection();
    }

    /** Get winner */
    public String getWinner() {
        return winner;
    }

    /** Set winner */
    public void setWinner(String sysElection, String userElection) {
        String winner;
        winner = switch (sysElection) {
            case "PAPER" -> paperBeats(userElection) ?
                    "Computer" : userElection.equalsIgnoreCase("PAPER") ?
                    "Tie" : "User";
            case "SCISSORS" -> scissorsBeats(userElection) ?
                    "Computer " : userElection.equalsIgnoreCase("SCISSORS") ?
                    "Tie" : "User";
            case "ROCK" -> rockBeats(userElection) ?
                    "Computer" : userElection.equalsIgnoreCase("ROCK") ?
                    "Tie" : "User";
            default -> "Tie";
        };
        this.winner = winner;
    }

    private boolean paperBeats(String RPS) {
        return RPS.equalsIgnoreCase( "ROCK");
    }

    private boolean scissorsBeats(String RPS) {
        return RPS.equalsIgnoreCase( "PAPER");
    }

    private boolean rockBeats(String RPS) {
        return RPS.equalsIgnoreCase("SCISSORS");
    }

    public static String getRandomElection() {
        String sysElection;
        sysElection = switch ((int) (Math.random() * 3)) {
            case 0 -> "PAPER";
            case 1 -> "SCISSORS";
            case 2 -> "ROCK";
            default -> "";
        };
        return sysElection;
    }
}
