#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int solutionGCD(int a, int b)
{
	if (b == 0)
		return a;
	else
		return solutionGCD(b, a % b);
}

int solutionLCM(int a, int b)
{
	return a * b / solutionGCD(a, b);
}

int main()
{
	int a, b;

	scanf("%d %d", &a, &b);

	printf("%d\n", solutionGCD(a, b));
	printf("%d\n", solutionLCM(a, b));
}