// Queens.java
// Duy Nguyen
// W1475318
// pa5
// N-Queens problem
class Queens{
    public static void main(String[] args){
        // determining if the user is selecting verbose mode
        boolean verbose = false;
        int n = 0;
        long fact;
        if(args.length==2) {
            if(args[0].equals("-v")){
                verbose = true; 
                try{
                    n = Integer.parseInt(args[1]);
                }catch(NumberFormatException e1){  
                    printUsageQuit();                    
                }catch(ArrayIndexOutOfBoundsException e2){
                    printUsageQuit();
                }
            }else{
                printUsageQuit();
            }
        }else if(args.length==1){
            verbose = false;
            try{
                n = Integer.parseInt(args[0]);
            }catch(NumberFormatException e3){
                printUsageQuit();
            }
        }else{
            printUsageQuit();
        }
        // calculations and output of solutions
        fact = factorial(n);
        int[] x = new int[n+1];
        for(int i=1;i<x.length;i++){
            x[i] = i;
        }
        int counter = 0;
        if(verbose==true){
            for(int i=1;i<=fact;i++){
                nextPermutation(x);
                if(isSolution(x)==true){
                    printArray(x);
                    counter++;
                }
            }
            System.out.println(n+"-Queens has "+counter+" solutions");
        }else{
            for(int i=1;i<=fact;i++){
                nextPermutation(x);
                if(isSolution(x)==true){
                    counter++;
                }
            }
            System.out.println(n+"-Queens has "+counter+" solutions");
        }
    }
    // method that finds the next permutation
    static void nextPermutation(int[] A){   
        int pivot = 0, successor = 0;
        for(int i=A.length-2;i>=1;i--){
            if(A[i]<A[i+1]){
                pivot = i;
                break;
            }
        }
        if(pivot == 0){
            reverse(A,0);
            return;
        }
        for(int i=A.length-1;i>=1;i--){
            if(A[i]>A[pivot]){
                successor = i;
                break;
            }
        }
        swap(A,pivot,successor);
        reverse(A, pivot);
        return;
    }
    // method to determine the placement of queens where no one queen can hit another
    static boolean isSolution(int[] A){
        boolean diagonal = true;
       int j; 
        for(int i=1;i<A.length;i++){
            j = i+1;
            while(j<A.length){
                if(Math.abs(i-j) == Math.abs(A[i]-A[j])){
                    diagonal = false;
                    return diagonal;
                }
                j++;
            }
        }
        return diagonal;
    }
    // method to print out this message if user enter something weird 
    static void printUsageQuit(){
        System.out.println("Usage: Queens [-v] number");
        System.out.println("Option: -v verbose output, print all solutions");
        System.exit(0);
    }
    // method to find the factorial
    static long factorial(int n){
        long result = 1;
        for(long i=1;i<=n;i++){
            result *= i;
        }
        return result;
    }
    // method to print out the array
    static void printArray(int[] A){
        int i;
        System.out.print("(");
        for(i=1;i<A.length-1;i++){
            System.out.print(A[i]+", ");
        }
        System.out.print(A[i]+")\n");
    }
    // method to swap pivot and successor
    static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    // methods to reverse the array at the pivot
    static void reverse(int[] A, int j){
        int[] B = new int[A.length];
        int k = A.length-1;
        for(int i=1;i<A.length;i++){
            B[i] = A[i];
        }
        for(int i=j+1;i<A.length;i++){
            B[i] = A[k];
            k--;
       }
       for(int i=1;i<A.length;i++){
           A[i] = B[i];
       } 
    }
}
