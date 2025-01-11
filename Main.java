public class Main {

    public static void main(String[] args) {

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

        Round System
        -3 to 5 rounds

        Money System
        -decided to not use a money system since we aren't buying anything with the money,
        so the money would have no use besides display

        */

        //currently working on the round system
        int currentRound = 1;
        while (Dice.drawableCards > 0) {
            System.out.println("\nYou are on Round " + currentRound);
            Dice.generateCards();
            Dice.rollDice();
            currentRound++;
            Dice.generatedCards.clear();
            Dice.rolledDices.clear();
        }

    }

}

/*

problem with the program:

Your cards are the following: [5, 1, 5]
You rolled: [5, 4, 6]
You have 2 points.

 */
