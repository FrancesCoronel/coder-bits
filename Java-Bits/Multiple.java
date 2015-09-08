//fvcproductions
//prints out multiplication table for any number

/* --- sample output with number = 5 ---

5 x 1 = 5
5 x 2 = 10
5 x 3 = 15
5 x 4 = 20
5 x 5 = 25
5 x 6 = 30
5 x 7 = 35
5 x 8 = 40
5 x 9 = 45
5 x 10 = 50

*/

class Multiple {
    
    public static void main(String args[]) {
        
        //will show multiplication table of 5 
        int number = 5; 
        int multiplier = 0;
        int result = 0;
        
        for (int i = 1; i <= 10; i++) {
            
            multiplier = i;
            result = multiplier*number;
            System.out.println(number + " x " + multiplier + " = " + result);
        
        }
        
    }
}