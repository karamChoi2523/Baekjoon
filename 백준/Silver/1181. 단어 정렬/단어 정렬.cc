#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Word {
	char w[51];
	int len;
}Word;

int compare(const void* a, const void* b) {
	Word w1 = *(Word*)a, w2 = *(Word*)b;
	if (w1.len < w2.len)
		return -1;
	else if (w1.len > w2.len)
		return 1;
	return strcmp(w1.w, w2.w);
}


int main()
{
	int n, i;

	scanf("%d", &n);

	Word* wlist = (Word*)malloc(sizeof(Word) * n);

	for (i = 0; i < n; i++) {
		scanf("%s", wlist[i].w);
		wlist[i].len = strlen(wlist[i].w);
	}
	
	qsort(wlist, n, sizeof(Word), compare);

	printf("%s\n", (wlist[0].w));

	for (i = 1; i < n; i++) {
		if (strcmp(wlist[i].w, wlist[i - 1].w) == 0)
			continue;
		else
			printf("%s\n", (wlist[i].w));
	}

	free(wlist);
}