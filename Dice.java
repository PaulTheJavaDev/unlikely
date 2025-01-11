import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Dice {

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Integer> generatedCards = new ArrayList<>();
    static ArrayList<Integer> rolledDices = new ArrayList<>();
    static int rerolls = 3;
    static int points = 0;
    static int drawableCards = 9; //one will be removed after each round

    /*
    Dice system
        -roll dice (1-6) - [completed]
        -draw 3 cards that show what dices you have to roll - [completed]
        -each dice that is equal to the given card dice is one point - [completed]
     */

    public static void generateCards() {
        //don't use HashSet cuz it ignores duplicates, remember?

        for (int i = 0; i < 3; i++) {
            int card = random.nextInt(0, 6) + 1;
            //System.out.println(card); //print each generated card
            generatedCards.add(card);
        }
        System.out.println("Your cards are the following: " + generatedCards); //print all 3 generated cards
        drawableCards--;
    }

    public static void rollBigDice() {
        //-roll big dice to randomly get: -1 point, -1 card, nothing, +1 card, +1 point
        int roll = random.nextInt(0, 5) + 1;
        switch (roll) {
            case 1 -> points--;
            case 2 -> drawableCards--;
            case 3 -> System.out.println("nothing happens");
            case 4 -> drawableCards++;
            case 5 -> points++;
        }

    }

    //rolls the dice 😆
    public static void rollDice() {
        for (int i = 0; i < 3; i++) {
            int dice = random.nextInt(0, 6) + 1;
            rolledDices.add(dice);
        }
        System.out.println("You rolled: " + rolledDices);

        System.out.println("Do you wanna reroll?");
        String userInput = scanner.nextLine();

        //if user didn't say yes, then continue with the game
        if (userInput.equalsIgnoreCase("yes")) {
            reroll();
            checkCards();
        } else {
            checkCards();
        }
    }

    public static void reroll() {
        rolledDices.clear();
        rerolls--;
        for (int i = 0; i < 3; i++) {
            int dice = random.nextInt(0, 6) + 1;
            rolledDices.add(dice);
        }
        System.out.println("You rolled: " + rolledDices);
        System.out.printf("\nYou now have %d rerolls left.\n", rerolls);
    }

    //checks if the rolled dices are equal to the cards also gives the points
    public static void checkCards() {
        for (int card : generatedCards) {
            rolledDices.contains(card);

            boolean containsNumber = rolledDices.contains(card);
            //System.out.println(containsNumber); //prints if the card that is loop a card from the generated cards

            if (containsNumber == true) {
                points++;
            }
        }
        //just a grammar readjustment of saying your points
        if (points == 0) {
            System.out.println("You have 0 points");
        } else if (points == 1) {
            System.out.println("You have 1 point");
        } else if (points > 1) {
            System.out.printf("\nYou have %d points.", points);
        }
    }

}
