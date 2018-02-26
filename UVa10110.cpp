/**
 *  TTL 
 *  Key : 而只有能被開平方根的時候因數個數才會為奇數
 */

#include <iostream>
#include <string>
#include <stdlib.h>
#include <math.h>

using namespace std;

int main() {

	int input ;
	int divCount;
	cin >> input;

	while(input != 0){
		int square = sqrt(input);
		divCount = 2;

		for(int i = square ; i > 1 ; i --) {
			if( input % i == 0 ) {
				if( input / i == i) divCount += 1;
				else divCount += 2;
			}
		}

		if(divCount % 2 == 0) cout << "no" << endl;
		else cout << "yes" << endl;

		cin >> input;
	}


	return 0;
}



