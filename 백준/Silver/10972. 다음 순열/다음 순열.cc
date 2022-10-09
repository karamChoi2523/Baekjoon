#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

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

	for (i = 0; i < n; i++)
		printf("%d ", A[i]);
	printf("\n");
}

int main()
{
	int n;
	int i, j;
	int arr[10000];

	scanf("%d", &n);
	
	for (i = 0; i < n; i++)
		scanf("%d", &arr[i]);

	for (i = n - 1; i > 0; i--)
		if (arr[i - 1] < arr[i])
			break;
	if (i == 0) {
		printf("-1\n");
		return 0;
	}

	int pivot = i - 1;
	int min = pivot + 1;

	for (i = pivot + 1; i < n; i++)
		if (arr[i] > arr[pivot] && arr[i] <= arr[min])
			min = i;

	int tmp = arr[min];
	arr[min] = arr[pivot];
	arr[pivot] = tmp;

	sorting(arr, pivot+1, n);
}