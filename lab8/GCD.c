/* GCD.c
 * Duy Nguyen
 * W1475318
 * lab8
 * finding the greatest common divisor between two inputted numbers
*/
#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int main(){
    int a, b, c;
    char d[100];
    printf("Enter a positive integer: ");
    while(1){
        a = scanf("%d", &b);
        while(a!=1){
            scanf("%s", &d);
            printf("Please enter a positive integer: ");
            a = scanf("%d", &b);
        }
        if(b>0){
            break;
        }
        printf("Please enter a positive integer: ");
    }
    printf("Enter another positive integer: ");
    while(1){
        a = scanf("%d", &c);
        while(a!=1){
            scanf("%s", &d);
            printf("Please enter a positive integer: ");
            a = scanf("%d", &c);
        }
        if(c>0){
            break;
        }
        printf("Please enter a positive integer: ");
    }

    printf("The GCD of %d and %d is %d\n", b, c, GCD(b, c));
    return 0;
}
int GCD(int a, int b){
    int c;
    while (a != 0 && b != 0){
        c = b;
        b = a%b;
        a = c;
    }
}
