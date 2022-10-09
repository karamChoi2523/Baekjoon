#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void testPrint(int* a, int size)
{
	for (int i = 0; i < size; i++)
		printf("%d ", a[i]);
	printf("\n");
}
void selectionSortNew(int A[], int left, int n)
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

}
int main(void)
{
	int n;
	int a[10000];
	int i;
	int pivot;
	int min;
	int temp;

	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d", &a[i]);

	for (i = n - 1; i > 0; i--) {
		if (a[i] > a[i - 1])	//뒤에 있는 것이 작아야 내림차순
			break;
	}
	if (i==0) {
		printf("-1\n");
		return 0;
	}
	pivot = i - 1;
	min = pivot + 1;
	for (i = pivot + 1; i < n; i++) {
		if (a[i] > a[pivot] && a[i] <= a[min])
			min = i;
	}
	//swap
	temp = a[min];
	a[min] = a[pivot];
	a[pivot] = temp;
	selectionSortNew(a, pivot + 1, n);
	testPrint(a, n);

	return 0;
}