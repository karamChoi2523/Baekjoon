#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void solution(int n)
{
	int number[5];
	int i;
	int len;

	for (i = 0; i < 5; i++)
		number[i] = 0;

	i = 0;
	while (n != 0) {
		number[i++] = n % 10;
		n /= 10;
	}
	len = i;

	for (i = 0; i <= len / 2; i++)
		if (number[i] != number[len - 1 - i]) {
			printf("no\n");
			break;
		}
	if (i == len / 2 + 1)
		printf("yes\n");
}

int main()
{
	int numlist[100000];
	int n;
	int i = 0;
	int cnt;

	while (1) {
		scanf("%d", &n);
		if (n == 0)
			break;

		numlist[i++] = n;

	}
	cnt = i;

	for (i = 0; i < cnt; i++)
		solution(numlist[i]);

	return 0;
}