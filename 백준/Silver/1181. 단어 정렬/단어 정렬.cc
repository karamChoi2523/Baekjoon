#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Word {
	char w[51];
	int len;
}Word;

//int partition(Word* wlist, int p, int r)
//{
//	int i, j, k = 0;
//	Word temp;
//
//	j = p;
//	i = p - 1;
//
//	for (; j < r; j++) {
//		if (wlist[j].len < wlist[r].len) {
//			i++;
//			temp = wlist[i];
//			wlist[i] = wlist[j];
//			wlist[j] = temp;
//		}
//		else if (wlist[j].len == wlist[r].len) {
//			if(strcmp(wlist[j].w, wlist[r].w)==-1){
//				i++;
//				temp = wlist[i];
//				wlist[i] = wlist[j];
//				wlist[j] = temp;
//			}
//		}		
//	}
//	i++;
//	temp = wlist[i];
//	wlist[i] = wlist[r];
//	wlist[r] = temp;
//
//	return i;
//}
//void quickSort(Word* wlist, int p, int r)
//{
//	int q;
//
//	if (p < r) {
//		q = partition(wlist, p, r);
//		quickSort(wlist, p, q - 1);
//		quickSort(wlist, q + 1, r);
//	}
//}
int compare(const void* a, const void* b) {
	Word s1 = *(Word*)a, s2 = *(Word*)b;
	if (s1.len < s2.len)
		return -1;
	else if (s1.len > s2.len)
		return 1;
	return strcmp(s1.w, s2.w);
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
	//quickSort(wlist, 0, n);

	printf("%s\n", (wlist[0].w));

	for (i = 1; i < n; i++) {
		if (strcmp(wlist[i].w, wlist[i - 1].w) == 0)
			continue;
		else
			printf("%s\n", (wlist[i].w));
	}

	free(wlist);
}