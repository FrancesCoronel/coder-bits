//Frances Coronel
//Calculates size of clothing

#include <iostream>
#include <string>
#include <cmath>

using namespace std;

double hat (double w, double h);
double jacket (double w, double h);
double waist (double w, double h);
int main ()

{
	
	double height;
	double weight;
	char yesno;
	do
	
	{
		cout << "Please enter your height (in inches). Note that 1 Foot = 12 inches:" << endl;
		cin >> height;
		
		cout << "Please enter your weight (in pounds):" << endl;
		cin >> weight;
		
		cout << "Your hat size is: " << hat(weight, height) << endl;
		cout << "Your jacket size is: " << jacket(weight, height) << endl;
		cout << "Your waist size is: " << waist(weight, height) << endl;
		cout << "Do you want to run again? Enter Y for yes or N for no" << endl;
		cin >> yesno;
	}
		while (yesno == 'y'|| yesno == 'Y');
		system("PAUSE");
		return 0;
	} 
		double hat (double w, double h)
		{double r;
		r = (w / h)*2.9;
		return (r);
	}
		double jacket (double w, double h)
		{double r;
		r = (w*h) / 288;
		return (r);
	}
		double waist (double w, double h)
		{double r;
		r = w/4.9; 
		return (r); 
		}