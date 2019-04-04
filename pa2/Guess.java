// Guess.java
// Duy Nguyen
// W1475318
// pa2
// Guessing game

import java.util.Scanner;

class Guess {

  public static void main(String[] args) {

    // importing scanner and declaring variables
    Scanner sc = new Scanner(System.in);
    int randomInteger, firstGuess, secondGuess, thirdGuess;

    // generation of random number inclusive between 1 and 10
    randomInteger = (int)((Math.random()*10+1));

    System.out.println("\nI'm thinking of an integer in the range 1 to 10. You"+
    " have three guesses.");

    // user's first guess and determination if they win or their guess is too
    // high or too low
    System.out.print("\nEnter your first guess: ");
    firstGuess = (int)sc.nextInt();
    if (firstGuess > randomInteger) {
      System.out.print("Your guess is too high.");
    } else if (firstGuess < randomInteger) {
      System.out.print("Your guess is too low.");
    } else {
      System.out.println("You win!\n");
      return;
    }

    // user's second guess and same process as first guess
    System.out.print("\n\nEnter your second guess: ");
    secondGuess = (int)sc.nextInt();
    if (secondGuess > randomInteger) {
      System.out.print("Your guess is too high.");
    } else if (secondGuess < randomInteger) {
      System.out.print("Your guess is too low.");
    } else {
      System.out.println("You win!\n");
      return;
    }

    // user's final guess and determining whether they won or lost
    System.out.print("\n\nEnter your third guess: ");
    thirdGuess = (int)sc.nextInt();
    if (thirdGuess == randomInteger) {
      System.out.println("You win!\n");
    } else {
      System.out.println("You lose. The number was "+randomInteger+".\n");
    }
  }
}
