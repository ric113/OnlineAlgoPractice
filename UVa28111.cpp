//
//  main.cpp
//  UVa28111
//
//  Created by Ricky on 2016/10/16.
//  Copyright © 2016年 Ricky. All rights reserved.
//

#include <iostream>
using namespace  std;
int data[50];


void printarr(int size )
{
    //cout << &data[0];
    for(int i =0 ; i < size ; i ++)
    {
        cout << data[i];
    }
    cout << endl;
}


void rec(int &sc ,int pos , int size)
{
    //cout << &data[0];
    if(pos <= size -1)
    {
        int minpos = pos;
        int temp;
        //cout << "sc =" << sc << endl;
        for(int i = pos+1 ; i < size ; i ++)
        {
            if(*(data+i) < *(data+minpos)){
                //cout << " min pos = " << i << endl;
                minpos = i;
            }
        }
        
        //cout << "pos = " << pos << endl;
        for(int j = minpos ; j >= pos+1 ; j --){
            temp = *(data + j);
            *(data+j) = * (data + (j-1));
            * (data + (j-1)) = temp;
        }
        minpos -= pos;
        sc += minpos;
        //printarr(size);
        rec(sc , pos+1 , size);
    }
}


int main(int argc, const char * argv[]) {
    // insert code here...
    int n , datanum , swapcount;
    //int data[50];
    cin >> n;
    for(int i = 0 ; i < n ; i ++)
    {
        swapcount = 0 ;
        cin >> datanum;
        for(int j = 0 ; j < datanum ; j ++)
        {
            cin >> data[j] ;
            
        }
        //cout << &data[0];
        rec(swapcount,0,datanum);
        cout << "Optimal train swapping takes "<< swapcount << " swaps." << endl;
        
    }
    
    //cout << "Hello, World!\n";
    return 0;
}
