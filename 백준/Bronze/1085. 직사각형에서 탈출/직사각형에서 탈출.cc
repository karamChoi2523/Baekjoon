#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define minFinder(a,b) a<b? a:b

int main()
{
	int x, y, w, h;

	scanf("%d %d %d %d", &x, &y, &w, &h);

	int min = minFinder(x, y);
	min = minFinder(min, w - x);
	min = minFinder(min, h - y);

	printf("%d\n", min);
}