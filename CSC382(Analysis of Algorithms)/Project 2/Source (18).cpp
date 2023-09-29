#include <iostream>
#include <iomanip>
#include <limits.h>

using namespace std;



// the array of size n
int Find(int x, int A[], int n) 
{
	int k;
	for (k = 0; k < n; k++) {
		if (x == A[k]) {
			return (k + 1);   //integer between 0 and bound

		}
	}
	return 0; // x is not an element of the array
}


// declaring the variables
void calculateAvg(int currbound) {
	int hits = 0;
	int theSequence[50];
	int totalSteps = 0;
	int steps;
	double q;
	double calcAvgerage;
	double realavgerage;


	// A for loop that is to count the average
	for (int k = 0; k < 10000; k++)
	{
		for (int i = 0; i < 50; i++){
			theSequence[i] = rand() % currbound;
		}
	
		if (Find(25, theSequence, 50))	{
			steps = Find(25, theSequence, 50);
			totalSteps += steps;
			hits++;
		}
		else
			totalSteps += 50;
	}

	q = (float)hits / (float)10000;
	calcAvgerage = 50 - (50 * q) + (q / 2);
	realavgerage = (float)totalSteps / (float)10000;

	
	//creating the format which will be displayed in the output
	if (currbound == INT_MAX)
		cout << "Infinite" << "\t" << calcAvgerage << "\t\t" << realavgerage << endl << endl;
	else
	cout << left << setw(16) << currbound << setw(16) << calcAvgerage << setw(16) << realavgerage << endl;
}


int main() {
	//will display the header in the output
	cout << "Bound\t" << "Calculated Average\t" << "Real Average" << endl;
	cout << "_______________________________________________________" << endl;

	calculateAvg(30);
	calculateAvg(50);
	calculateAvg(80);
	calculateAvg(100);
	calculateAvg(1000);
	calculateAvg(10000);
	calculateAvg(INT_MAX);


	return 0;
}