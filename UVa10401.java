package com.company;
import java.util.Scanner;

public class Main {

    static long[][] board ;
    public static void main(String[] args) {
	// write your code here
        Scanner keyboard = new Scanner(System.in);
        String input ;
        long a;
        //System.out.print(toInt('F'));
        while(keyboard.hasNextLine())
        {
            input = keyboard.nextLine();
            input = input.trim();
            board = new long[input.length()+1][input.length()+1];
            a = 0;
            //System.out.println("length = " + input.length());
            // Init .
            if(input.charAt(0) == '?')
            {
                for(int i = 1 ; i <= input.length() ; i ++)
                {
                    board[1][i] = 1;
                }
            }
            else{
                if(49<=input.charAt(0) && input.charAt(0)<=57)
                    board[1][input.charAt(0)-48] = 1;
                else if(65<=input.charAt(0) && input.charAt(0)<=90)
                    board[1][input.charAt(0)-55] = 1;
            }
            //

            for(int i = 2 ; i <= input.length() ; i ++)
            {
                if(input.charAt(i-1) == '?') {
                    for (int j = 1; j <= input.length(); j++) {
                        for (int k = 1; k < j - 1; k++)
                            board[i][j] += board[i - 1][k];
                        for (int k = j + 2; k <= input.length(); k++)
                            board[i][j] += board[i - 1][k];
                    }
                }
                else{
                    if(49<=input.charAt(i-1) && input.charAt(i-1)<=57) {
                        for (int k = 1; k < input.charAt(i - 1) - 49; k++)
                            board[i][input.charAt(i - 1) - 48] += board[i - 1][k];
                        for (int k = input.charAt(i - 1) - 46; k <= input.length(); k++)
                            board[i][input.charAt(i - 1) - 48] += board[i - 1][k];
                    }
                    else if(65<=input.charAt(i-1) && input.charAt(i-1)<=90)
                    {
                        for (int k = 1; k < input.charAt(i - 1) -56; k++)
                            board[i][input.charAt(i - 1)-55] += board[i - 1][k];
                        for (int k = input.charAt(i - 1)-53; k <= input.length(); k++)
                            board[i][input.charAt(i - 1)-55] += board[i - 1][k];
                    }
                }
            }

            for(int i = 1 ; i <= input.length() ; i ++)
                a += board[input.length()][i];
            System.out.println(a);


        }
    }

}
