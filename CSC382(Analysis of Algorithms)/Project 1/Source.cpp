#include <iostream>

#include <iomanip>

using namespace std;
int dp[10000];


// recursive algorithm
int FiboR(int n) // array of size n
{
	if (n == 0 || n == 1)
		return (n);
	else
		return (FiboR(n - 1) + FiboR(n - 2));
}


// modified recursive algo
int MODFibR(int n)
{
	if (n == 0 || n == 1)
		return n;
	if (dp[n] != -1)
		return dp[n];
	dp[n] = MODFibR(n - 1) + MODFibR(n - 2);
	return dp[n];
}


// non recursive algorithm
int FiboNR(int n) // array of size n
{
	int F[10000];
	F[0] = 0; F[1] = 1;
	for (int i = 2; i <= n; i++) {
		F[n] = F[n - 1] + F[n - 2];
	}
	return (F[n]);
}
int main()
{
	//creating the header for the table
	cout << left
		<< setw(15) << "INTEGER"
		<< setw(15) << "FiboR "
		<< setw(15) << "MODfibR"
		<< setw(15) << "FiboNR "


		<< endl;


	memset(dp, -1, 10000);
	clock_t t, t1;
	double needed_time;

	// using the loop we will get the output values

	for (int i = 5; i <= 60; i += 5)
	{
		int curr = i;
		cout << curr;
		t = clock();
		FiboR(curr);
		t1 = clock();
		needed_time = ((double)((double)t1 - (double)t)) / CLOCKS_PER_SEC;
		printf("     |         %.2f", needed_time);

		t = clock();
		FiboNR(curr);
		t1 = clock();
		needed_time = ((double)((double)t1 - (double)t)) / CLOCKS_PER_SEC;
		printf("    |       %.2f", needed_time);

		t = clock();
		MODFibR(curr);
		t1 = clock();
		needed_time = ((double)((double)t1 - (double)t)) / CLOCKS_PER_SEC;
		printf("   |      %.2f", needed_time);
		cout << endl;
	}
	return 0;
}
