// GCD.java
// Duy Nguyen
// W1475318
// pa3
// Finding the greatest common divisor between two integers

import java.util.*;

class GCD {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int firstNumber, secondNumber;
   
    // getting the first integer and determining if it's an integer
    System.out.print("Enter a positive integer: ");

    while (true) {

      if (scanner.hasNextInt()) {

        firstNumber = scanner.nextInt();
   
        if (firstNumber > 0)
          break;

        else
          System.out.print("Please enter a positive integer: ");
          continue;

      }

      scanner.next();
      System.out.print("Please enter a positive integer: ");

    }

   // getting the secnod number and determining whether it is an integer
   System.out.print("Enter another positive integer: ");
 
   while (true) {

      if (scanner.hasNextInt()) {
 
        secondNumber = scanner.nextInt();

        if (secondNumber > 0)
          break;

        else    
          System.out.print("Please enter a positive integer: ");
          continue;
         
      }

      scanner.next();
      System.out.print("Please enter a positive integer: ");

    }

    // printing out the GCD of the two inputted numbers
    System.out.println("The GCD of "+firstNumber+" and "+secondNumber+" is "+
    GCD(firstNumber, secondNumber)+".");

  }
  // method to find the GCD of both numbers
  public static int GCD(int firstNumber, int secondNumber) {

    // continues loop until a remainder or zero is found then returns it
    while (firstNumber != 0 && secondNumber != 0) {

      int second = secondNumber;
      secondNumber = firstNumber%secondNumber;
      firstNumber = second;

    }

    return firstNumber;

  }

} 
