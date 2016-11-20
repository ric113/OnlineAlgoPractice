package com.company;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner keyboard = new Scanner(System.in);
        String input ;
        int k,j;
        char temp ;
        char[] c;
        while(keyboard.hasNextLine())
        {
            k = -1 ;
            input = keyboard.nextLine();
            if(input.equals("#"))
                break;
            c = input.toCharArray();


            for(int i = c.length-1 ; i > 0 ; i --)
            {
                if(c[i] >  c[i-1])
                {
                    k = i ;
                    break ;
                }
            }

            if(k == -1)
            {
                System.out.println("No Successor");
                continue;
            }

            int target = FindSmallerIndex(c,k);
            temp = c[target] ;
            c[target] = c[k-1] ;
            c[k-1] = temp ;

            //for(int i = c.length - 1 ; i >=k ; i --)

            Arrays.sort(c,k,c.length);
            System.out.println(String.valueOf(c));


        }

    }

    public static int FindSmallerIndex(char[] c , int k)
    {

        int minIndex = k;
        for(int i = k+1  ; i < c.length ; i ++)
        {
            if(c[k-1]<c[i] && c[i]<c[k]) minIndex = i;
        }
        return minIndex;
    }


}
