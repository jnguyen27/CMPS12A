// Roots.java
// Duy Nguyen
// W1475318
// pa4
// Determines the real roots of a polynomial that lie within a specific range
import java.util.*;
class Roots {
// main method that asks for user's inputs and then gives them the roots
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    double resolution = Math.pow(10,-2), tolerance = Math.pow(10,-7);
    double threshold = Math.pow(10,-3);

    System.out.print("Enter the degree: ");
    int degree = scanner.nextInt();

    int coefficient = degree + 1;
    System.out.print("Enter the "+coefficient+" coefficients: ");
    double[] C = new double[degree+1];   
    // creates an array with the users inputs for coefficients
    for (int i=0; i<C.length; i++) {

      C[i] = scanner.nextDouble();

    }
    // creates a derivate array of whay the user inputted
    double[] der = new double[C.length-1];
    der = diff(C);   

    System.out.print("Enter the left and right endpoints: ");
    double left = scanner.nextDouble();
    double right = scanner.nextDouble();

    double a = left, b = left + resolution, root = 0.0;

    boolean exist = false;
    System.out.println();
    //finds the roots in the given range specified in the instructions
    while(a<=right) {
        if (poly(C,a)*poly(C,b) <= 0) {

          System.out.print("Root found at: ");
          System.out.printf("%.5f%n", findRoot(C,a,b,tolerance));
          exist = true;

          } if (poly(der,a)*poly(der,b) <= 0) {

          root = findRoot(der,a,b,tolerance);
          if (Math.abs(poly(C,root))<threshold) {

            System.out.print("Root found at: ");
            System.out.printf("%.5f%n", root);
            exist = true;

          }

        } 
        a = b;
        b += resolution;
    }
    if (!exist) {
 
      System.out.println("\nNo roots were found in the specified range.");

    } 

   
    }

    // takes an array of doubles and a double x value and multiplies each
    // indecy by the corresponding power, adds it to the sum, then returns
    // the sum
    static double poly(double[] C, double x) {

    double sum = 0.0;
    for (int i=0; i<C.length; i++) {

      sum += C[i]*Math.pow(x,i);

    }    
    return sum;

    }

    // takes an array of doubes and finds the derivative, returning a new array
    // with the length
    static double[] diff(double[] C) {

    double[] D = new double[C.length];
    for(int i=1; i<=C.length-1; i++) {

      D[i-1] = C[i]*i;
   
    } 
    return D;

    }

    // finding the root of function
    static double findRoot(double[] C, double a, double b, double tolerance) {

    double root = 0.0;
    
    while (b - a > tolerance) {

      root = (a+b)/2;
      if (poly(C,a) * poly(C,root) <= 0) {

        b = root;

      } else {

        a = root;

      }
     
    }
    return root;
   }
   
}
