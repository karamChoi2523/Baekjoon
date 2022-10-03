#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	int n, res = 0;

	scanf("%d", &n);

	for (int i = 1; i <= n; i*=10)
		res += n - i + 1;

	printf("%d\n", res);
}