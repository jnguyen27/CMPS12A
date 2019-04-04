// Lawn.java
// Duy Nguyen
// W1475318
// pa1
// Finding the mowing rate of a lawn
import java.util.Scanner;

class Lawn {

  public static void main(String[] args) {

    double lengthLot, widthLot, lengthHouse, widthHouse, lawnArea, 
    mowingRate, mowingTime;
    int h, m, s;
    Scanner sc = new Scanner(System.in);

    lengthLot = sc.nextDouble();
    widthLot = sc.nextDouble();
	
    lengthHouse = sc.nextDouble();
    widthHouse = sc.nextDouble();
    
    lawnArea = (lengthLot * widthLot) - (lengthHouse * widthHouse);
    System.out.println("The lawn area is "+lawnArea+" square feet.");
	
    mowingRate = sc.nextDouble();
    mowingTime = lawnArea/mowingRate;
    s = (int) Math.round(mowingTime);
    m = s/60;
    s = s%60;
    h = m/60;
    m = m%60;

    System.out.println("The mowing time is "+h+" hour"+(h==1?" ":"s ") +m+
    " minute" +(m==1?" ":"s ")+s+" second"+ (s==1?".":"s."));
	
    }
}
