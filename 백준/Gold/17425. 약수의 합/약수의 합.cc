#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

long long list[1000001];

int main()
{
    int T, N;
    long long sum = 0;
    scanf("%d", &T);

    for (int i = 1; i <= 1000001; i++) {
        for (int j = i; j <= 1000001; j += i) {
            list[j] += i;
        }
    }

    for (int i = 2; i <= 1000001; i++) {
        list[i] += list[i - 1];
    }

    for (int j = 0; j < T; j++) {
        scanf("%d", &N);
        printf("%lld\n", list[N]);
    }

    return 0;
}