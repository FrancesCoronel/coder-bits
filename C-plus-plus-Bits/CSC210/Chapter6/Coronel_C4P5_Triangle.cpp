/*

In-Class 04
CSC 210
2-3-15
FVCproductions

(Recursion: Triangle Pattern) 

You are to write an entire C++ program with recursive function that will accept 2 numbers (m and n) and it will be a pattern of 2*(n-m+1) lines to the screen. 
 
The first line contains m asterisks, the next line contains m+1 asterisks, and so on up to a line with n asterisks.

Then the pattern is repeated backwards, going n back down to m. m is less than n.

Note that you must validate the 2 input that m is less than n.

e.g. triangle ( 3, 5) will output

***
****
*****
*****
****
***

*/

#include <iostream>

using namespace std;

int triangle(int m, int n)
{
	if (m > n){
		if (n == 1)
		{
			for (int i = 1; i <= m; i++)
			{
				for (int j = 1; j <= i; j++)
				{
					cout << "*";
				}
				cout << "\n";
			}
		}
		else 
		{

			
			for (int i = m; i >= n; i--)
			{
				for (int j = i; j > 1; j--)
				{
					cout << "*";
				}
				cout << "\n";
			}
		}
		
	}

}

int main() {
	
	int m, n;
	
	cout << "Enter m: ";
	cin >> m;
	
	cout << "Enter n: ";
	cin >> n;
	
	cout << triangle(m,n);
	
}