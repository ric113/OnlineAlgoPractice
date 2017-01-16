#include <iostream>
#include <string>
#include <stdlib.h>

using namespace std;

int main(int argc, const char * argv[]) {

	int table[11];
	int n ;
	table[1] = 1;
	table[2] = 2;

	for(int i = 3 ; i <= 10 ; i ++)
	{
		int sum = 0;
		for(int j = 1 ; j <= i - 2 ; j ++ )
			sum += table[j] * table[i - j - 1] ;
		table[i] = 2 * table[i - 1] + sum ;
	}

	while(cin >> n){
		cout << endl;
		cout << table[n] << endl ;

	}

	return 0;
}