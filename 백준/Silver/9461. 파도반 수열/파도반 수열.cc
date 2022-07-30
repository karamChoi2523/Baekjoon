#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

void solution(long long* arr, int n)
{
	int i;

	for (i = 5; i < n; i++) {
		arr[i] = arr[i - 5] + arr[i - 1];
	}

	printf("%lld\n", arr[n - 1]);
}
int main()
{
	//1,1,1,2(1+1),2,3(1+2),4(1+3),5(1+4),7(2+5),9(2+7),12(3+9),16(4+12),21(16+5)
	int t;
	int* list;
	long long arr[101];
	int i;

	scanf("%d", &t);

	list = (int*)malloc(sizeof(int) * t);
	arr[0] = arr[1] = arr[2] = 1;
	arr[3] = arr[4] = 2;

	for (i = 0; i < t; i++)
		scanf("%d", &list[i]);

	for (i = 0; i < t; i++)
		solution(arr, list[i]);

	free(list);
}