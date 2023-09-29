#include <iostream>
#include <chrono>
#include <iomanip>
#include <random>
#include <ctime>
using namespace std;
using namespace std::chrono;

void insertSort(int* list, int n)
{
	for (int i = 1; i < n; i++) {

		int z, x = list[i];
		for (z = i - 1; z > -1; z--) {
			if (list[z] > x) {
				list[z + 1] = list[z];
			}
			else {
				break;
			}
		}
		list[z + 1] = x;
	}
}


void swap(int& x, int& z)
{
	int t = x;
	x = z;
	z = t;
}

//sorry for using the word heapify i know you dont like it
void merge(int aray[], int l, int m, int r)
{
	int num1 = m - l + 1, num2 = r - m;
	int al[num1], ar[num2];
	for (int i = l; i < m + 1; i++)
	{
		al[i - l] = aray[i];
	}
	for (int i = m + 1; i < r + 1; i++)
	{
		ar[i - (m + 1)] = aray[i];
	}
	int i = 0, j = 0, k = l;
	while (i < num1 && j < num2)
	{
		if (al[i] - 1 < ar[j])
		{
			aray[k] = al[i];
			i++;
			k++;
		}
		else {
			aray[k] = ar[j];
			j++;
			k++;
		}
	}
	while (i < num1)
	{
		aray[k] = al[i];
		i++;
		k++;
	}
	while (j < num2)
	{
		aray[k] = ar[j];
		j++;
		k++;
	}
}
void mergeSort(int arr[], int l, int r) {
	if (l < r) {
		int m = l + (r - l) / 2;
		mergeSort(arr, l, m);
		mergeSort(arr, m + 1, r);
		merge(arr, l, m, r);
	}
}

void theheap(int fall, int* arr, int n)
{
	int l = fall;
	if (2 * fall + 1 < n)
	{
		if (arr[2 * fall + 1] > arr[l]) {
			l = 2 * fall + 1;
		}
	}
	if (2 * fall + 2 < n) {
		if (arr[2 * fall + 2] > arr[l])
		{
			l = 2 * fall + 2;
		}
	}
	if (l != fall) {
		swap(arr[l], arr[fall]);
		theheap(l, arr, n);
	}
}


void heapSort(int arr[], int n)
{
	for (int i = n / 2 - 1; i >= 0; i--)
	{
		theheap(i, arr, n);
	}
	for (int i = n - 1; i > 0; i--) {
		swap(arr[0], arr[i]);
		theheap(0, arr, i);
	}
}


int main()
{
	int n[] = { 1000,10000,25000,50000,150000,250000 };
	cout << "_________________________________________________________________________________________________________" << endl;
	cout << "Input Length\t    Heap Sort(s)\t      Insertion Sort(s)\t        Merge Sort(s)\t       Best Time\n";
	cout << "_________________________________________________________________________________________________________" << endl;
	srand(time(0));
	for (int i = 0; i < 6; i++)
	{
		int nn = n[i];
		int heap[nn], instert[nn], merge[nn];
		for (int i = 0; i < nn; i++)
		{
			int t = rand();
			heap[i] = instert[i] = merge[i] = t;
		}

		auto start = high_resolution_clock::now();
		heapSort(heap, nn);
		auto stop = high_resolution_clock::now();
		auto hd = duration_cast<microseconds>(stop - start);
		start = high_resolution_clock::now();
		insertSort(instert, nn);
		stop = high_resolution_clock::now();
		auto id = duration_cast<microseconds>(stop - start);
		start = high_resolution_clock::now();
		mergeSort(merge, 0, nn - 1);
		stop = high_resolution_clock::now();
		auto md = duration_cast<microseconds>(stop - start);
		double t1 = hd.count() / (double)1000000; //the time for heap
		double t2 = id.count() / (double)1000000; // the time insertion 
		double t3 = md.count() / (double)1000000; //time for merge 
		string ans;
		if (t1 < t2 && t1 < t3)
		{
			ans = "Heap";
		}
		else if (t2 < t3 && t2 < t1)
		{
			ans = "Insertion";
		}
		else
		{
			ans = "Merge";
		}
		cout << fixed << setprecision(5) << nn << " \t\t\t" << t1 << "\t\t\t" << t2 << "\t\t\t" << t3 << "\t\t\t" << ans << endl;
	}

}



//TESTING
/*

void heapify(int n, int i)
{
int largest = i;
int l = 2 * i + 1;
int r = 2 * i + 2;
if (l < n && heap_el[l] > heap_el[largest])
largest = l;
if (r < n && heap_el[r] > heap_el[largest])
largest = r;
if (largest != i)
{
int temp = heap_el[i];
heap_el[i] = heap_el[largest];
heap_el[largest] = temp;
heapify(n, largest);
}
}

void heapSort(int n)
{
int i = 0;
for (i = n; i >= 0; i--)
heapify(n, i);
for (i = n; i > 0; i--)
{
int temp = heap_el[0];
heap_el[0] = heap_el[i];
heap_el[i] = temp;
heapify(i, 0);
}
}*/