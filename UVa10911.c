//
//  main.c
//  Uva10911
//
//  Created by Ricky on 2016/9/1.
//  Copyright © 2016年 Ricky. All rights reserved.
//

/*
 *	UVa 10911 :
 *		概念 : DP & 狀態壓縮
 *			假設有 N 隊 ， 總共有 2N 個人 ， 每個人有"已在某隊伍內"和"尚未被分組"兩種狀態，可以 0/1 表示
 *			因此可以用一個長 2N 的二進位字串表示當下每個人的狀態：
 *				e.g. 假設預計會有三組(N=3)，因此會有六個人(令他們為A,B,C,D,E,F)，假設AB已被分為同組，但CDEF尚未分組，
 *					 所以其狀態字串為"110000"(左到右分別代表ABCDEF) 。
 *			所以若有2N個人，總共會有 2^2N 個狀態，因此我們建立一個陣列dp[]，其Size為2^2N，而其中即存放每個狀態下的Min Length.
 *			其中DP想法為 ：
 *				dp[S] = 將S轉成二進位後，任意取出兩個其狀態是 1 的bit(假設取出第i , j bit)，然後計算dp[S-{i}-{j}]+dis(i,j)，取最小者。
 *				然後在遞迴設定dp[S-{i}-{j}],即可求出最終最佳解dp[S].
 *					＊把S想成一個二進位字串，而S-{i}-{j}代表將S的第i、j個bit設成 0.
 *				其中終止狀態dp[O] = 0 .
 *
 *
 */

#include <stdio.h>
#include <math.h>
#define min(a,b) (a<b)?a:b
int max;
int n;
int x[20];
int y[20];
double dist[20][20],dp[1<<16];
char name[20];
int count = 0 ;
double DP(int state)
{
    //printf("call count : %d \n" , ++ count);
    //printf("dp[state] =  %f \n" , dp[state]);
    if(dp[state]!=-1) // 若某個狀態已被set,代表該狀態下之最佳解即其值了 .
    {
        //printf("Return dp : %f \n" , dp[state]);
        return dp[state];
    }
    else
    {
        int i,j;
        double m=1<<30;
        // 從左至右每次取兩個bit,走遍所有state下之狀態 , e.g. state = 1111 : 0011 -> 0101 -> 0110 -> 1001 -> 1010 -> 1100
        for(i = 2*n;i > 1;i--){
            if(state&(1<<(i-1))){ // check該bit是否是1.
                for(j=i-1;j>=1;j--){
                    if(state&(1<<(j-1))){ // check該bit是否是1.
                        //printf("i = %d , j = %d\n" , i , j);
                        //printf("%d\n",state^(1<<(i-1))^(1<<(j-1)));
                        double temp = minD(state^(1<<(i-1))^(1<<(j-1)));
                        m = min(m,dist[i-1][j-1]+temp);
                        //printf("m = %f\n" , m );
                    }
                }
            }
        }
        return dp[state]=m;
    }
}
int main()
{
    //printf("%f",dp[1]);
    int i,j,cc=1;
    scanf("%d",&n);
    while(n)
    {
        max = (1<<(2*n))-1; // 代表1向左位移2n個bit後-1 .
        //printf("%d\n",max);
        for(i=0;i<2*n;i++)
            scanf("%s %d %d",name,x+i,y+i);
        for(i=0;i<2*n;i++)
            for(j=i+1;j<2*n;j++)
                dist[i][j]=dist[j][i]=sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]));
        for(i=0;i<=max;i++) // 表格初始化 .
            dp[i]=-1;
        dp[0] = 0 ; // 終止條件設定 .
        printf("Case %d: %.2lf\n",cc++,DP(max));
        //for(i=0;i<=5;i++)
        //    printf("dp[%d] = %f " , i , dp[i]);
        scanf("%d",&n);
    }
    return 0;
}
