package javabasics.hangman;

public class Hangman {

    public static void main(String[] args) {
        System.out.printf("This is the Hangman Game\n");

        Game game = new Game("treehouse"); //this creates the default game with the answer: "treehouse"

        //Now that there's a game, I need to have my player start guessing!
        Prompter prompter = new Prompter(game);
//        prompter.displayProgress();

        while(!game.isLive(game.getCurrentProgress())){
            System.out.printf("You have %d tries to solve %s%n", game.getRemainingTries(), game.getCurrentProgress());
            game.getCurrentProgress();
            char guess = prompter.promptForGuess();
            boolean isHit = game.applyGuess(guess);
        }

    }
}
