//project name "Solid Geometry"
//calculates volume, surface area, and cross section of sphere
//name: Frances Coronel
//type of input: radius, surface_ara, volume, cross_section
//type of output: actual volume, surface_area, and cross_section calculated
//brief description of algorithm: calculate surface area, volume, or cross-sectional area of sphere

#include <iostream>
#include <iomanip>
#include <cmath>
using namespace std;
const char QUIT = 'Q';
const float PI = 3.1415927;
int main()
{
	float radius, surface_area, volume, cross_section;
	char method;
	cout << "Please enter\n" 
         << "V for volume,\n"
         << "A for surface area"
         << ",X for cross-sectional area,\n"
         << "and finally Q if you would like to quit.\n";
	cin  >> method;
    
    while(method != QUIT)
      {
       cout << "Now please enter the radius of your sphere.\n";
       cin  >> radius;
       if(method == 'V')                         
          {
          volume = 4.0/3.0 * PI * radius * radius * radius;
          cout << "The volume of the sphere is:" <<volume<<endl
          }
       else if(method == 'A')
          {
          surface_area = 4.0 * PI * radius * radius;
          cout << "The surface area of the sphere is:" <<surface_area<<endl;          
          }
       else if(method == 'X')
          {
          cross_section =  PI * radius * radius;
          cout << "The cross section of the sphere is:" <<cross_section<<endl;       
          }
       cout << "Please enter\n" 
            << "V for volume,\n"
            << "A for surface area"
            << "X for cross-sectional area,\n"
            << "and finally Q if you would like to quit.\n";
	   cin  >> method;
}
    system("pause");    
    return 0;                                         
}
