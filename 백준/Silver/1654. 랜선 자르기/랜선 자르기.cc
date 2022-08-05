#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

//이진탐색을 사용할 것!!!
int main()
{
	int n, k;
	int i, j;

	long long* have;
	long long len = 0, max = 1, cnt = 0;
	long long left, right, mid;

	scanf("%d %d", &k, &n);
	have = (long long*)malloc(sizeof(long long) * k);

	for (i = 0; i < k; i++) {
		scanf("%lld", &have[i]);
		if (max < have[i])
			max = have[i];
	}
	left = 1;
	right = max;

	while (left <= right) {
		mid = (left + right) / 2;

		for (i = 0, cnt = 0; i < k; i++)
			cnt += have[i] / mid;
		if (n <= cnt && len < mid)
			len = mid;
		if (cnt < n)
			right = mid - 1;
		else
			left = mid + 1;
	}

	printf("%lld\n", len);

	free(have);
}