// FVCproductions

// Lab Chapter 16: numberverifier.cpp
#include <iostream>
#include <cmath>
#include <string>
#include <stdexcept>
using namespace std; 

// class NonNumber definition
class NonNumber : public runtime_error
{
public:

   // constructor
   NonNumber()
      : runtime_error( "non-integer detected" ) 
   {
      // empty
   } // end class NonNumber definition

}; // end class NonNumber

// class NonNumber definition
class Overflow : public overflow_error
{
public:

   // constructor
   Overflow()
      : overflow_error( "overflow detected" ) 
   {
      // empty
   } // end class NonNumber definition

}; // end class NonNumber

// function castInput definition
int castInput( string input )
{
   int result = 0;
   int negative = 1;

   // check for minus sign
   if ( input[ 0 ] == '-' )
     negative = -1;

   for ( int i = input.length() - 1, j = 0; i >= 0; i--, j++ )
   {
      if ( negative == -1 && i == 0 )
         continue;

      if ( input[ i ] >= '0' && input[ i ] <= '9' )
         result += static_cast< int >( input[ i ] - '0' ) * pow( 10.0, j );   

      else
         throw NonNumber();
      
      if ( input.length() >= 10 ) 
         throw Overflow();
         
			/*******************************************/
         /* Write code to throw NonNumber exception */
			/*******************************************/

   } // end for

   return result * negative;

} // end function castInput


int main()
{
   string input;
   int convert; 

   cout << "Please enter a number (end-of-file to terminate): ";

   while ( cin >> input )
   {
		/*******************************************/
      /* Write try block that calls castInput */
      /* Write catch handler that catches any exceptions
         that the call to castInput might have thrown */
		/*******************************************/
      try 
      {
         cout << "The numbered entered was: " << castInput( input ) << endl;
      }
            
      catch ( NonNumber &e )
      {
         cout << "Invalid Input... " << e.what() << endl;
      }
      catch ( Overflow &f )
      {
         cout << "Invalid Input... " << f.what() << endl;
      } 

      cout << "\nPlease enter a number (end-of-file to terminate): ";
   } // end while

   cout << endl;
} // end main


/**************************************************************************
 * (C) Copyright 1992-2015 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 **************************************************************************/
