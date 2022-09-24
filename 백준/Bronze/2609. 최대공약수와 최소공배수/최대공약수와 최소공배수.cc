#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int solutionA(int a, int b);
void solutionB(int a, int b, int gcf);

int main()
{
	int a, b;

	scanf("%d %d", &a, &b);

	int gcf = solutionA(a, b);
	solutionB(a, b, gcf);
}

int solutionA(int a, int b)
{
	int min = a > b ? b : a;

	for (int i = min; i>=1 ; i--)
		if (a % i == 0 && b % i == 0) {
			printf("%d\n", i);
			return i;
		}
}

void solutionB(int a, int b, int gcf)
{
	printf("%d\n", gcf * (a / gcf) * (b / gcf));
}