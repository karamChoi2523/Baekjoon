#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	int n, a;
	long long num = 1;

	while (~scanf("%d", &n)) {
		num = 1;
		a = 1;

		while (1) {
			if (num % n != 0) {
				num = (num % n) * 10 + 1;
				a++;
			}
			else {
				printf("%d\n", a);
				break;
			}
		}
	}
	return 0;
}