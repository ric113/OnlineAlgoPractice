//
//  main.cpp
//  UVa00729
//
//  Created by Ricky on 2016/10/9.
//  Copyright © 2016年 Ricky. All rights reserved.
//

#include <iostream>
#include <string>
using namespace std;


void Recr(string,int,int);

int main(int argc, const char * argv[]) {
    // insert code here...
    int count , N , H;
    
    cin >> count ;
    
    for(int i = 0 ; i < count ; i++)
    {
        cin >> N;
        cin >> H;
        Recr("",N,H);
    }
    
    return 0;
}

void Recr(string s,int N , int H)
{
    if(H == 0 && N != 0){
        s.insert(s.end(), N-H,'0');
        cout << s << endl;
    }
    else if(N>0 && N == H){
        s.insert(s.end(), H , '1');
        cout << s << endl;
    }
    else{
        Recr(s+'0', N-1, H);
        Recr(s+'1' , N-1 , H-1);
    }
        
}
