#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

void swap(int first, int second)
{
	int temp;

	temp = first;
	first = second;
	second = temp;
}
void pick(int n, int m, int* picked, int toPick)
{
	int i, j;
	int lastIndex;

	if (toPick == 0) {
		for (i = 0; i < m; i++)
			printf("%d ", picked[i]);
		printf("\n");
		return;
	}
	
	lastIndex = m - toPick - 1;

	for (i = 1; i <= n; i++) {
		for (j = 0; j <= lastIndex; j++)
			if (picked[j] == i)
				break;
		if (j == lastIndex+1) {
			picked[lastIndex + 1] = i;
			pick(n, m, picked, toPick - 1);
		}
	}
}
int main()
{
	int n, m;

	scanf("%d %d", &n, &m);
	int* picked = (int*)malloc(sizeof(int) * n);

	pick(n, m, picked, m);
	free(picked);
}