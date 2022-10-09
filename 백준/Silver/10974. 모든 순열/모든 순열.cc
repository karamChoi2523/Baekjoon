#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int factorial(int n)
{
	int res = 1;

	for (int i = 2; i <= n; i++)
		res *= i;
	return res;
}

void printArr(int* arr, int n)
{
	for (int i = 0; i < n; i++)
		printf("%d ", arr[i]);
	printf("\n");
}

void sorting(int* A, int left, int n)
{
	int i, j;
	int maxIndex;
	int temp;

	for (i = 0; i < n - 1 - left; i++) {
		maxIndex = left;
		for (j = left; j < n - i; j++)
			if (A[maxIndex] < A[j])
				maxIndex = j;
		temp = A[maxIndex];
		A[maxIndex] = A[n - i - 1];
		A[n - i - 1] = temp;
	}

	printArr(A, n);
}

void solution(int *arr, int n)
{
	int i, j;

	for (i = n - 1; i > 0; i--)
		if (arr[i - 1] < arr[i])
			break;

	int pivot = i - 1;
	int min = pivot + 1;

	for (i = pivot + 1; i < n; i++)
		if (arr[i] > arr[pivot] && arr[i] <= arr[min])
			min = i;

	int tmp = arr[min];
	arr[min] = arr[pivot];
	arr[pivot] = tmp;

	sorting(arr, pivot + 1, n);
}
int main()
{
	int n;
	int i;
	int arr[8];

	scanf("%d", &n);

	for (i = 0; i < n; i++)
		arr[i] = i + 1;

	printArr(arr, n);

	for(i=0;i<factorial(n) - 1;i++)
		solution(arr, n);

}