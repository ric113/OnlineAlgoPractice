#include <cstdio>
#include <iostream>

using namespace std;


int main() {

	int i ;

	while(scanf("%d", &i) != EOF) {
		if(i == 0) break;
		int sum = 0;

		for(int j = 1 ; j <= i ; j ++) {
			sum += (i - j + 1) * (i - j + 1);
		}

		cout << sum << endl;
	}

	return 0;
}