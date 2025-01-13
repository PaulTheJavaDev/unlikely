import java.util.Scanner;

public class Main {

    static int rounds = Dice.drawableCards;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /*

        inspired by https://nachogames.itch.io/unlikely with my own additions

        Dice system - [completed]
        -roll dice (1-6)
        -draw 3 cards that show what dices you have to roll
        -each dice that is equal to the given card dice is one point

        Card System - [uncompleted]
        -draw card
        -roll big dice to randomly get: -1 point, -1 card, nothing +1 card, +1 point

        rerolls: 3 - [completed]
        -one gets added each proceeding round



        Clown
        -killsUser action
        -Sound System
        --make the clown speak (for loop with dialog)

        Money System
        -decided to not use a money system since we aren't buying anything with the money,
        so the money would have no use besides display

        */

        int currentRound = 1;
        boolean rolledBigDiceThisRound = false;

        Clown.loopSound("src/Audio/scar-ambience.wav");
        Clown.randomlyPlaySound("src/Audio/doors-lights-flicker.wav", 5000, 15000);
        
        Clown.startDialog("Let’s play a game."); //testing dialog - [works], adjust sound
        Clown.startDialog("Take a card and then roll all 3 dice.");
        Clown.startDialog("For each hit you get a point.");
        Clown.startDialog("We will play, until you don’t have any cards left.");
        Clown.startDialog("Reach at least 10 points to see your family again.");
        Clown.startDialog("You can also roll the big die to get an extra card.");
        Clown.startDialog("But beware, you only have a 40 percent chance of hitting.");
        Clown.startDialog("You will start with 9 cards, 0 points and 3 rerolls.");
        Clown.startDialog("Good luck.");
         

        while (Dice.drawableCards > 0) {

            //randomly play lights flicker sound
            //Clown.randomlyPlaySound("src/Audio/doors-lights-flicker.wav", 5000, 15000);

            //checks if the game should be ended currentRound > rounds
            if (currentRound > rounds) {
                if (Dice.points == 10) {
                    System.out.println("You won the game!");
                    System.exit(0);
                } else {
                    System.out.println("You lost my friend...");
                    Clown.killUser();
                    System.exit(0);
                }
            }

            //menu board
            System.out.println("\nYou are on round " + currentRound);
            System.out.println("+----------------------------------------+");
            System.out.println("|            Select an Option            |");
            System.out.println("+----------------------------------------+");
            System.out.println("|  1. Roll the big dice                  |");
            System.out.println("|  2. Draw cards                         |");
            System.out.println("|  3. Exit game                          |");
            System.out.println("+----------------------------------------+");

            int userInput = scanner.nextInt();
            scanner.nextLine();

            //
            if (rolledBigDiceThisRound) {
                switch (userInput) {
                    case 1 -> {
                        System.out.println("You aren't able to roll this dice this game anymore!");
                    }
                    case 2 -> {
                        Dice.generateCards();
                        Dice.rollDices();
                        currentRound++;
                    }
                    case 3 -> System.exit(0);
                    default -> System.out.println("Please enter a valid number!");
                }
            } else {
                switch (userInput) {
                    case 1 -> {
                        Dice.rollBigDice();
                        rolledBigDiceThisRound = true;
                    }
                    case 2 -> {
                        Dice.generateCards();
                        Dice.rollDices();
                        currentRound++;
                    }
                    case 3 -> System.exit(0);
                    default -> System.out.println("Please enter a valid number!");
                }
            }

            //resets the ArrayLists so no bugs there can occur
            Dice.generatedCards.clear();
            Dice.rolledDices.clear();

        }

        //here is the end of while loop
        scanner.close();
        System.exit(0);
    }

}

}
