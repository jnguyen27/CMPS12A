class Array {

  public static void main(String[] args) {

    int [] list = new int[10];
    int i;
    int n = list.length;

    for (i=0; i<n; i++ ) {

      list[i] = 3*i;

    }

    for (i=0; i<n; i++) {

      System.out.print(list[i]+" ");

    }
    System.out.println();

  }

}
