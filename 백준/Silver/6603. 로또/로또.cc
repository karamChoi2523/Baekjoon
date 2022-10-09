#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

//조합
void pick(int* item, int n, int* picked, int m, int toPick)
{
	int i, lastIndex, smallest;

	if (toPick == 0) {
		for (i = 0; i < m; i++)
			printf("%d ", item[picked[i]]);
		printf("\n");
		return;
	}
	lastIndex = m - toPick - 1;

	if (toPick == m)
		smallest = 0;
	else
		smallest = picked[lastIndex] + 1;

	for (i = smallest; i < n; i++) {
		picked[lastIndex + 1] = i;
		pick(item, n, picked, m, toPick - 1);
	}
}

int main()
{
	int k;
	int arr[63];
	int s[49];
	int i, j;
	int len;
	int* picked;

	for (i = 0; i < 63; i++) {
		scanf("%d", &arr[i]);
		if (arr[i] == 0)
			break;
	}
	len = i;
	i = 0;
	while (len > 0) {
		k = arr[i];
		picked = (int*)malloc(sizeof(int) * k);

		for (j = 1; j <= k; j++) {
			s[j - 1] = arr[i + j];
		}
		if (i != 0)
			printf("\n");
		pick(s, k, picked, 6, 6);
		i += (k + 1);
		len -= (k + 1);

		free(picked);
	}

	return 0;
}