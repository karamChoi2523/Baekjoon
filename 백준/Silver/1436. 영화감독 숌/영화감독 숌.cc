#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int solution(int n)
{
	while (n != 0) {
		if (n % 1000 == 666)
			return 1;
		n /= 10;
	}
	return 0;
}

int main()
{
	
	int n;
	int i;
	int cnt = 0;
	int res = 665;

	scanf("%d", &n);

	while (cnt != n) {
		res++;
		if (solution(res))
			cnt++;
	}
	printf("%d\n", res);
}