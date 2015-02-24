/*
fvcproductions
prints out following:

-
++
---
++++
-----
++++++
-------
++++++++
---------
++++++++++

*/


class SymbolArt {
    
    public static void main(String args[]) {
        char positive = '+';
        char negative = '-';
        
        // your code here
        for(int i=1; i<=10; i++) {
                for(int j=1; j<=i; j++) {
                    if (i % 2 != 0) {
                        System.out.print(negative);
                    }
                    else {
                        System.out.print(positive);
                    }
                }
            System.out.println();
        }
    }
}