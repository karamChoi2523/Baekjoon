#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main()
{
	int m, n;
	int* arr;	//소수는 1, 아니면 0
	int i, j;

	scanf("%d %d", &m, &n);
	arr = (int*)malloc(sizeof(int) * (n+1));

	for (i = 0; i < n + 1; i++)
		arr[i] = 1;

	for (i = 2; i < n + 1; i++) {
		if (arr[i] == 1) {
			if (i * i > 1000000)
				break;
			else {
				for (j = i * i; j < n + 1; j += i)
					arr[j] = 0;
			}
		}
	}

	if (m == 1) m++;

	for (i = m; i < n + 1; i++)
		if (arr[i] && i >= m)
			printf("%d\n", i);

	free(arr);
	
}