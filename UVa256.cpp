#include <iostream>
#include <string>
#include <stdlib.h>
#include <stdio.h>
#include <math.h>

using namespace std;

int digit[] = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};


int main() {

	int input;

	while(scanf("%d", &input) != EOF) {
		int h, l;
		for(int i = 0 ; i * i < digit[input] ; i ++) {
			h = (i * i) / digit[input/2];
			l = (i * i) % digit[input/2];
			if((h+l) * (h+l) == i * i)
				printf("%0*d\n", input, i * i);
		}
	}
	

	return 0;
}

