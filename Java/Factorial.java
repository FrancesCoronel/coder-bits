//fvcproductions
//calculates factorial of 10
//e.g the factorial of 10 or 10! = 10*9*8*7*6*5*4*3*2*1

class Factorial {
    
    public static void main(String args[]) {
       
       int number = 10;
       int factorial = 1;
       
       for (int i = 1; i <= number; i++) {
           
           factorial = factorial * i;
       
       }
        
        System.out.println("The factorial of 10 is " + factorial)
    
    }
}
