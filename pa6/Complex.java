// Complex.java
// Duy Nguyen
// W1475318
// pa6
// Complex class for complex numbers
class Complex{
    // private data fields
    private double re;
    private double im;

    // public constant fields
    public static final Complex ONE = Complex.valueOf(1,0);
    public static final Complex ZERO = Complex.valueOf(0,0);
    public static final Complex I = Complex.valueOf(0,1);

    // constructors
    Complex(double a, double b){
        this.re = a;
        this.im = b;
    }

    Complex(double a){
        this.re = a;
        this.im = 0;
    }

    Complex(String s){
        double[] part = parseComplex(s);
        this.re = part[0];
        this.im = part[1];
    } 
    // parsing Complex from string
    static double[] parseComplex(String str){
      double[] part = new double[2];
      String s = str.trim();
      String NUM = "(\\d+\\.\\d*|\\.?\\d+)";
      String SGN = "[+-]?";
      String OP =  "\\s*[+-]\\s*";
      String I =   "i";
      String OR =  "|";
      String REAL = SGN+NUM;
      String IMAG = SGN+NUM+"?"+I;
      String COMP = REAL+OR+
                    IMAG+OR+
                    REAL+OP+NUM+"?"+I;
      
      if( !s.matches(COMP) ){
         throw new NumberFormatException(
                   "Cannot parse input string \""+s+"\" as Complex");
      }
      s = s.replaceAll("\\s","");     
      if( s.matches(REAL) ){
         part[0] = Double.parseDouble(s);
         part[1] = 0;
      }else if( s.matches(SGN+I) ){
         part[0] = 0;
         part[1] = Double.parseDouble( s.replace( I, "1.0" ) );
      }else if( s.matches(IMAG) ){
         part[0] = 0;
         part[1] = Double.parseDouble( s.replace( I , "" ) );
      }else if( s.matches(REAL+OP+I) ){
         part[0] = Double.parseDouble( s.replaceAll( "("+REAL+")"+OP+".+" , "$1" ) );
         part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+")"+I , "$1"+"1.0" ) );
      }else{   //  s.matches(REAL+OP+NUM+I) 
         part[0] = Double.parseDouble( s.replaceAll( "("+REAL+").+"  , "$1" ) );
         part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+NUM+")"+I , "$1" ) );
      }
      return part;
   }

    // public methods

    // copy()
    // return a new complex equal to this complex
    Complex copy(){
      return new Complex(this.re,this.im);
    }

    // add()
    // return a new complex representing the sum this plus z
    Complex add(Complex z){
        return new Complex(this.re+z.re,this.im+z.im);
    }

    // negate()
    // return a new complex representing the negative of this
    Complex negate(){
        return new Complex(-this.re,-this.im);
    }

    // sub()
    // return a new complex representing the difference this minuz z
    Complex sub(Complex z){
        return new Complex(this.re-z.re,this.im-z.im);
    }

    // mult()
    // return a new complex representing the product this times z
    Complex mult(Complex z){
         return new Complex(this.re*z.re-this.im*z.im,this.re*z.im+this.im*z.re);
    }

    // recip()
    // return a new complex representing the reciprocal of this
    // throw an ArithmeticException with appropriate message if
    // this.equals(Complex.ZERO)
    Complex recip(){
        if(this.equals(Complex.ZERO)){
            throw new ArithmeticException("Cannot divide by zero.");
        }else{
            return new Complex(this.re/(Math.pow(this.re,2)+Math.pow(this.im,2)
            ),-this.im/(Math.pow(this.re,2)+Math.pow(this.im,2)));
        }
    }

    // div()
    // return a new complex representing the quotient of this by z
    // Throw an ArithmeticException with appropriate message if 
    // z.equals(Complex.ZERO)
    Complex div(Complex z){
        if(z.equals(Complex.ZERO)){
            throw new ArithmeticException("Cannot divide by zero.");
        }else{
            return new Complex((z.re*this.re+z.im*this.im)/(Math.pow(z.re,2)+Math.pow
            (z.im,2)), (z.re*this.im-z.im*this.re)/(Math.pow(z.re,2)+Math.pow
            (z.im,2)));
        }
    }

    // conj()
    // return a new complex representing the conjugate of this complex
    Complex conj(){
        return new Complex(this.re, -this.im);
    }

    // Re()
    // return the real part of this
    double Re(){
        return re;
    }

    // Im()
    // return the imaginary part of this
    double Im(){
         return im;
    }

    // abs()
    // return the modulus of this complex, i.e. the distance
    // between points (0, 0) and (re, im)
    double abs(){
        return Math.sqrt(Math.pow(this.re,2) + Math.pow(this.im,2));
    }

    // arg()
    // return the argument of this complex, i.e. the angle this complex
    // makes with positive real axis
    double arg(){
        return Math.atan2(im, re);
    }

    // other functions
    
    // toString()
    // return a string representation of this complex
    // the string returned will be readable by the constructor Complex(String s)
    public String toString(){
       if(this.im<0){
           if(this.re==0){
               return this.im+"i";
           }else{
               return this.re+""+this.im+"i";
           }
       }else if(this.re==0){
           if(this.im==0){
               return "0";
           }else{
               return this.im+"i";
           }
       }else if(this.im==0){
           if(this.re==0){
               return "0";
           }else{
               return this.re+"";
           }
       }
       return this.re+"+"+this.im+"i";
    }

    // equals()
    // return true if this and obj have the same real and imaginary parts
    public boolean equals(Object obj){
        Complex c = (Complex) obj;
        if(this.re == c.re && this.im == c.im){
            return true;
        }else{
            return false;
        }
    }

    // valueOf()
    // return a new complex with real part a and imaginary part b
    static Complex valueOf(double a, double b){
        return new Complex(a,b);
    }

    // valueOf()
    // return a new complex with real part a and imaginary art 0
    static Complex valueOf(double a){
        return new Complex(a);
    }

    // valueOf()
    // return a new complex constructed from s
    static Complex valueOf(String s){
        return new Complex(s);
    }
}
