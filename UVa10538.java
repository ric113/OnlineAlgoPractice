package com.company;

import java.util.Scanner;
import java.util.ArrayList;


public class Main {

    static int arr[];
    static int rank[];

    public static void main(String[] args) {
	// write your code here
        Scanner keyboard = new Scanner(System.in);
        int peopleNum , TeamNum , a , b ,p_a,p_b, groupCount , Case = 1;


        while(keyboard.hasNextInt())
        {
            peopleNum = keyboard.nextInt();
            TeamNum = keyboard.nextInt();

            if ( peopleNum == 0 && TeamNum == 0)
                break;

            groupCount = peopleNum;
            arr = new int[peopleNum+1];
            rank = new int[peopleNum+1];
            Init();

            for(int i = 0 ; i < TeamNum ; i ++)
            {
                a = keyboard.nextInt();
                b = keyboard.nextInt();

                p_a = Find(a);
                p_b = Find(b);

               if(p_a != p_b){
                   Union(a,b,p_a,p_b);
                   groupCount -- ;
               }


            }

            System.out.println("Case " + Case +": " + groupCount);
            Case ++ ;
        }
    }

    public static void Init()
    {
        for(int i = 0 ; i < arr.length ; i ++)
        {
            arr[i] = i ;
        }
    }

    public static int Find(int node)
    {
        if (arr[node] == node)
            return node;
        return Find(arr[node]);
    }

    public static void Union(int a , int b , int root_a,int root_b)
    {
        int temp,root,sub;
        if(rank[root_a] == rank[root_b]){
            root = root_a;
            sub = b;
            rank[root] ++;
        }
        else if(rank[root_a] > rank[root_b]){
            root = root_a;
            sub = b;
        }
        else{
            root = root_b;
            sub = a;
        }

        while(sub != arr[sub])
        {
            temp = sub;
            sub = arr[sub];
            arr[temp] = root;
        }
        arr[sub] = root;
    }
}
