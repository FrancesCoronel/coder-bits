//Frances Coronel
//Reads numbers into an array of integers 
//and then manipulates the array
//Program 4

#include <iostream>
using namespace std;

const int MAXSIZE = 25;
void getlist(int[], int&);
void putlist(const int[], int);
void reverse(const int[], int);
void EvenValues(const int[], int);
void GreaterThan(const int[], int);

int main ()
	{
	int list [MAXSIZE];
    int num_items;
 
    getlist(list, num_items);
    putlist(list, num_items);
    reverse(list, num_items);
    EvenValues(list, num_items);
    GreaterThan(list, num_items);
    
    system("pause");
    return 0;
	}
	
void getlist(int list[], int& num_items)
	{
    int i;
    cout<<"Please enter the number of array values"<<endl;
	cin>>num_items;
    for(i=0; i<num_items;i++)
    {
    cout<<"Enter the next array value"<<endl;
    cin>>list[i]; 
	}
    }
 
void putlist(const int list[], int num_items)
	{
    cout<<"Array Elements"<<endl;
    for (int i=0; i<num_items; i++)
		cout<<i<<" "<<list[i]<<endl;
	}

void reverse(const int list[], int num_items)
	{
     cout<<"List in Reverse Order"<<endl;
     for (int i=num_items - 1; i>=0; i--)
         cout<<i<<" "<<list[i]<<endl;
     }

void EvenValues(const int list[], int num_items)
	{
     cout<<"Even Values"<<endl;
     for (int i=0; i<=num_items; i++)
         if (list[i]%2 == 0)
            cout<<i<<" "<<list[i]<<endl;
	}

void GreaterThan(const int list[], int num_items)
	{
     cout<<"Greater Than"<<endl;
     for (int i=0; i <= num_items-1; i++)
         if (list[i]>list[i + 1])
            cout<<i<<" "<<list[i]<<endl;
	}
	
