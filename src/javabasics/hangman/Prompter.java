package javabasics.hangman;
import java.util.Scanner;
//this is going to be getting guesses from the user
//I'll need something to accept input - how about a scanner?

public class Prompter {
    private Game game;
    //need a constructor for a prompter
    public Prompter(Game game) {
        this.game = game;
        //this will assign the game that gets passed in as the private game variable in this class, for better security
    }

    //SPECIAL POWER: Ask for a guess AND
        // TEST if it's right or wrong
    public char promptForGuess() {
        game.getRemainingTries();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a letter to guess: "); //this will display a line to the user to input something

        //Ask until you get valid input


            // I should force the guess to be lower case


        String guessInput = sc.nextLine().toLowerCase(); //This will set "guess" equal to whatever the line is that was just entered

        //need to validate input
        if(!validInput(guessInput) ) {
            System.out.println("You didn't enter valid input");
        }

        System.out.println("# of chars: " + guessInput.length());
if (guessInput.length()==0) {
    System.out.println("You entered nothing");
    System.exit(0);
}
//        if (sc.hasNext()) {
//            System.out.println("SC does NOT have next");
//            //TESTING//
//            //System.out.printf("[Prompter] The guess was: %s\n", guessInput);
//        }
        return guessInput.charAt(0);
//        return game.applyGuess(guessInput.charAt(0));

    }

    public void displayProgress() {
        System.out.printf("You have %d tries%n", game.getRemainingTries());
        System.out.printf("Try to solve %s%n", game.getCurrentProgress());
    }

}
