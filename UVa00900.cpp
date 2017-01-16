#include <iostream>
#include <string>
#include <stdlib.h>

using namespace std;

int main(int argc, const char * argv[]) {

	int n = 1 ;
	long long fib[51] ;
	fib[1] = 1;
	fib[2] = 2;

	/* 需建表 , 否則單純跑 recursive 會 timeout */
	for(int i = 3 ; i <= 50 ; i ++)
	{
		fib[i] = fib[i-1] + fib[i-2];
	}
	
	while( n != 0 )
	{
		cin >> n ;
		if(n == 0) break;
		cout << fib[n] << endl ;
	}

	return 0;
}