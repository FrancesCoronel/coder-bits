//project name "Time Measurements"
//reads time measurements from the keyboard in hours and minutes
//FVCproductions
//type of input: hours 1, hours 2, minutes 1, minutes 2
//type of output: time in hours and minutes and time as a real number
//brief description of algorithm: adds two data sets of hours and minutes 

#include <iostream>
#include <iomanip>
using namespace std; 

int main()
{ 
    int hour1, hour2, minutes1, minutes2, total_hours, total_minutes;
    float fraction_hours;
    
    cout<<fixed<<setprecision (2);
    
    cout<< "Please type in 1st hour: ";
    cin>> hour1;
    cout<< "Please type in 1st minute: ";
    cin>> minutes1;
    cout<< "Please type in 2nd hour: ";
    cin>> hour2;
    cout<< "Please type in 2nd minute: ";
    cin>> minutes2;
    
    total_minutes = hour1*60+minutes1+hour2*60+minutes2;
    total_hours = total_minutes / 60;
    total_minutes = total_minutes%60;
    fraction_hours = total_hours+total_minutes/60.0;
    
    cout << total_hours << " hours " << total_minutes << " minutes \n"; 
    cout << fraction_hours << " hours \n";
    
    system("pause");
    
    return 0;
}
   
    
