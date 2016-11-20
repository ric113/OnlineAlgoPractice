//
//  main.cpp
//  UVa12503
//
//  Created by Ricky on 2016/10/16.
//  Copyright © 2016年 Ricky. All rights reserved.
//

#include <iostream>
#include <string>
#include <stdlib.h>

using namespace std;

int main(int argc, const char * argv[]) {
    // insert code here...
    string  act;
    string temp_c;
    int action[100];
    int n , datanum , res , temp;
    cin >> n ;
    for(int i = 0 ; i < n ; i ++)
    {
        res = 0 ;
        cin >> datanum;
        getline(cin,act);
        for(int j = 0 ; j < datanum ; j ++)
        {
            
            getline(cin,act);
            if(act == "LEFT")
            {
                res -= 1;
                action[j] = -1;
            }
            else if(act == "RIGHT")
            {
                res += 1;
                action[j] = 1;
            }
            else
            {
                temp_c = act.substr(act.find("AS")+3 , act.length()-1);
                //cout << "char = " << temp_c << endl;
                temp = atoi(temp_c.c_str());
                //cout << "temp" << temp << endl;
                action[j] = action[temp-1];
                res += action[temp-1];
            }
            
        }
        cout << res << endl;
    }
    
    //cout << "Hello, World!\n";
    return 0;
}
