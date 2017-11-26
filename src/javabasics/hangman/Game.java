package javabasics.hangman;

//THIS IS FOR MY GAME LOGIC

public class Game {
    //this class will construct a game
    public static final int MAX_MISSES = 7;
    private int triesLeft = MAX_MISSES;
    private String misses;
    private String answer;
    private String hits;
    private boolean solved = false;

    //This class will hold the LOGIC for the hangman game
    public Game(String answer) {
        //I should have the answer, it should be PRIVATE
        this.answer = answer;
        hits = "";
        misses = "";
        //I should keep track of hits and misses
        //I need to test if the letter guessed is in the answer
    }

    public int getRemainingTries() {
        return MAX_MISSES - misses.length();
    }

// SPECIAL POWER: Say if a guess is in the answer OR not
    public boolean applyGuess(char letter) {
        //Game has an answer, so test against that answer
//        //if the guess was ALREADY made then they should be told they already guessed that, no changes to the hits or misses
        if ( (hits.indexOf(letter) != -1) | (misses.indexOf(letter) != -1)) {
            System.out.println("You already guessed that!");
//          //  THEN tell them to fuck off and guess again, they already did that guess
        } else if (answer.indexOf(letter) != -1 ) {
            hits += letter;
////            System.out.println("current hits: " + hits);
        } else if (triesLeft>=0){
            triesLeft--;
            misses += letter;
//            System.out.println("current misses: " + misses);
//            System.out.println("tries left: " + triesLeft);
        } else {
            System.out.println("You lose. Better luck next time");
            System.exit(0);
        }
        return answer.indexOf(letter) != -1;
    }



    //I should have a way to display the current progress





    public boolean isLive(String progress){
        int i=0;
        if(progress.indexOf('-') == -1) {
            this.solved = true;
            System.out.println("YOU WIN!!!");
            System.out.println("The answer is: " + answer);
        }
//        System.out.println("RESULT: " + progress);
        return solved;
    }
//    public boolean isLive(String progress){
//        String progress = "";
//        int i=0;
//        for(char x: answer.toCharArray()) {
//            if (hits.indexOf(x) != -1) {
//                progress += x;
//            } else {
//                progress += "-";
//            }
//        }
//        if(progress.indexOf('-') == -1) {
//            this.solved = true;
//            System.out.println("YOU WIN!!!");
//            System.out.println("The answer is: " + answer);
//        }
//        System.out.println("RESULT: " + progress);
//        return solved;
//    }

    // TREEHOUSE tutorial says to do this as a String
    public String getCurrentProgress() {
        String progress = "";
        for (char letter: answer.toCharArray()) {
            char display = '-';
            if (hits.indexOf(letter) != -1) {
                display = letter;
            }
            progress += display;
        }
        return progress;
    }

//    public void displayProgress() {
//        System.out.println("PROGRESS DISPLAY...");
//        String progress = "";
//        //cycle through the answer, char by char
//        for(int i = 0; i < answer.length(); i++) {
//            //if the char is in the hits string, then it should be displayed as the char itself because it was guessed
//            //if (answer.charAt(i)) //is contained in the hits)
//            if(hits.indexOf(i) != -1) {
//                System.out.println(answer.charAt(i));
//            }
//        }
////        System.out.print(answer.toCharArray());
//    }
}
