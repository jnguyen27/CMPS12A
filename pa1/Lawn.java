// Lawn.java
// Duy Nguyen
// W1475318
// pa1
// Finding the mowing rate of a lawn
import java.util.Scanner;

class Lawn {

  public static void main(String[] args) {

    // declaration of variable that will be used throughout program
    double lengthLot, widthLot, lengthHouse, widthHouse, lawnArea, 
    mowingRate, mowingTime;
    int h, m, s;
    Scanner sc = new Scanner(System.in);

    // asking and and saving user input of the length and width to the declared
    // variable
    System.out.print("Enter the length and width of the lot, in feet: ");
    lengthLot = sc.nextDouble();
    widthLot = sc.nextDouble();
	
    // doing the same as finding the length and width of lot but for the house
    System.out.print("Enter the length and width of the house, in feet: ");
    lengthHouse = sc.nextDouble();
    widthHouse = sc.nextDouble();
    
    // determining and printing out the lawn area
    lawnArea = (lengthLot * widthLot) - (lengthHouse * widthHouse);
    System.out.println("The lawn area is "+lawnArea+" square feet.");
	
    // asking and saving the mowing rate to the declalred variable
    System.out.print("Enter the mowing rate, in square feet per second: ");
    mowingRate = sc.nextDouble();
    
    // calculating the mowing time mowing time into hours, minutes, and seconds
    mowingTime = lawnArea/mowingRate;
    s = (int) Math.round(mowingTime);
    m = s/60;
    s = s%60;
    h = m/60;
    m = m%60;

    // printing out the time and determining whether that certain time 
    // declaration requires to be plural
    System.out.println("The mowing time is "+h+" hour"+(h==1?" ":"s ") +m+
    " minute" +(m==1?" ":"s ")+s+" second"+ (s==1?".":"s."));
	
    }
}
