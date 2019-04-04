/* Sphere.c 
 * Duy Nguyen
 * W1475318
 * lab7
 * finding the volume and surface area of a sphere in C
*/
#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int main() {
    const double pi = 3.141592654;
    double r, v, sa;

    printf("Enter the radius of the sphere: ");
    scanf("%lf", &r);
    v = (4.0/3.0)*pi*pow(r,3);
    sa = 4*pi*pow(r,2);
    printf("The volume is %f and the surface area is %f.\n", v, sa);

    return 0;
}
