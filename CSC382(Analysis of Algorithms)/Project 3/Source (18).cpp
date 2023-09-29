#include <iostream>
#include <iomanip>
#include <cmath>
#include <ctime>

using namespace std;
int Insertion_mod(int A[], int);

int main()
{

    //declaring variables and giving some of them values
    srand(time(NULL));
    int n[] = { 100, 500, 1000, 2500 };
    double calculateAverage;
    double realAverage;
    int bound = 10000;
    int repeat = 100000;

    //creating the hearder and body format
    cout << "Input Size" << setw(25) << "Calculated Average" << setw(20) << "Real Average" << endl;
    cout << "------------------------------------------------------------" << endl;
    for (int i = 0; i < sizeof(n); i++)
    {
        int inputSize = n[i];
        int* array = new int[inputSize];
        long long int totalNumSteps = 0;

        // will create 100,000  sequences
        for (int j = 0; j < repeat; j++)
        {
            for (int f = 0; f < inputSize; f++) {
                array[f] = rand() % bound;
            }
            // calling Insertion_mod
            int inserFunction = Insertion_mod(array, inputSize);
            totalNumSteps += inserFunction;
        }


        // over here i will calculate the average
        calculateAverage = (pow(inputSize, 2) / 4) + (3 * inputSize / 4);
        // calculating the real average
        realAverage = static_cast<double>(totalNumSteps) / repeat;


        cout << setprecision(2) << fixed;
        cout << setw(5) << inputSize << setw(25) << calculateAverage << setw(20) << realAverage << endl;
    }
    return 0;
}


int Insertion_mod(int A[], int n)
{ // in reality the elements to be sorted are indexed from index 1 to index n
    int i, j, temp;
    int steps = 0;
    A[0] = -32768; // smallest possible integer using 2 bytes integer representation
    for (i = 1; i <= n; i++)
    {
        j = i;
        while (A[j] < A[j - 1])
        { // swap
            temp = A[j];
            A[j] = A[j - 1];
            A[j - 1] = temp;
            j--;
            steps++;
        }
        steps++;
    }
    return steps;
}
