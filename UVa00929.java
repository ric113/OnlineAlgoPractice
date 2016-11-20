// Dijkstra + Min Heap  : 點到點找最短路徑
package com.company;

import java.util.Scanner;
import java.util.ArrayList;



public class Main {

    static ArrayList<Node> Heap = new ArrayList<Node>();

    public static void main(String[] args) {
	// write your code here
        Scanner keyboard = new Scanner(System.in);
        int MazeNum = keyboard.nextInt();
        int row , col , cost[][] ,min[][];
        boolean visited [][];

        for(int k = 0 ; k < MazeNum ; k ++) {

            row = keyboard.nextInt();
            col = keyboard.nextInt();
            cost = new int[row][col];
            min = new int[row][col];
            visited =new boolean[row][col];

            for(int i = 0 ; i < row ; i ++)
            {
                for(int j = 0 ; j < col ; j ++)
                {
                    cost[i][j] = keyboard.nextInt();
                    visited[i][j] = false;
                    //min[row][col] = Integer.MAX_VALUE;
                }
            }

            Init_Heap();

            Node start_point = new Node();
            start_point.x = 0 ;
            start_point.y = 0 ;
            start_point.min_cost = cost[0][0] ;

            Insert(start_point);
            visited[0][0] = true;
            //keyboard.next();
            Node temp ;

            //showHeap(Heap);

            //keyboard.next();
            while(Heap.size() > 1)
            {
                temp = Extract_Min();

                //System.out.println("temp.x = :" + temp.x);
                //System.out.println("temp.y = :" + temp.y);
                //System.out.println("temp.cost = :" + temp.min_cost);

                //System.out.println("After Extract Min :");
                //showHeap();

                min[temp.x][temp.y] = temp.min_cost;
                //visited[temp.x][temp.y] = true;

                //System.out.println("min :" + min[temp.x][temp.y]);

                if(temp.x - 1 > -1 && !visited[temp.x-1][temp.y]) {
                    Insert(new Node(temp.x - 1, temp.y, temp.min_cost + cost[temp.x - 1][temp.y]));
                    visited[temp.x-1][temp.y] = true;
                }
                if(temp.y - 1 > -1 && !visited[temp.x][temp.y-1]) {
                    Insert(new Node(temp.x, temp.y - 1, temp.min_cost + cost[temp.x][temp.y - 1]));
                    visited[temp.x][temp.y-1] = true;
                }
                if(temp.x + 1 < row && !visited[temp.x+1][temp.y]) {
                    Insert(new Node(temp.x + 1, temp.y, temp.min_cost + cost[temp.x + 1][temp.y]));
                    visited[temp.x+1][temp.y] = true;
                }
                if(temp.y + 1 < col && !visited[temp.x][temp.y+1]) {
                    Insert(new Node(temp.x, temp.y + 1, temp.min_cost + cost[temp.x][temp.y + 1]));
                    visited[temp.x][temp.y+1] = true;
                }
            }

            System.out.println(min[row-1][col-1]);


        }
    }
    // 先插入一個點當起始 index 0 !!

    public static void Init_Heap()
    {
        Heap.clear();
        Node start = new Node();
        Heap.add(start);
    }

    public static void Insert(Node node)
    {
        Heap.add(node);

        int parent_index = (Heap.size()-1)/2;
        int current_index = Heap.size()-1;
        int key = node.min_cost;

        while(key < Heap.get(parent_index).min_cost && current_index != 1) {
            Heap.set(current_index , Heap.get(parent_index));
            current_index /= 2;
            parent_index /= 2;
        }
        Heap.set(current_index , node);

        //System.out.println("Insert Done! , show Heap:");
        //showHeap();

    }

    public static Node Extract_Min()
    {
        Node min = Heap.get(1);
        Node last = Heap.get(Heap.size()-1);

        Heap.set(1,last);
        Heap.remove(Heap.size()-1);


        if(Heap.size() != 1) {
            //System.out.println("root = " + Heap.get(1).min_cost);
            //System.out.println("tree size = " + Heap.size());
            Heapfiy(1);
            //System.out.println("After HeapFiy :");
            //showHeap();
        }

        return min;
    }

    public static void Heapfiy(int index)
    {
        int key = Heap.get(index).min_cost;
        int i = index ;
        int j = 2 * i ;
        Node startNode = Heap.get(index);

        //System.out.println("before heapfiy :");
        //showHeap();

        while(j < Heap.size())
        {
            if(j+1 < Heap.size()){
                if(Heap.get(j+1).min_cost < Heap.get(j).min_cost)
                    j = j+1 ;
            }

            if(key<Heap.get(j).min_cost)
                break;

            Heap.set(i,Heap.get(j));
            i = j ;
            j = 2 * i;
        }

        Heap.set(i , startNode);
    }

    public static void showHeap()
    {
        for(int i = 0 ; i < Heap.size() ; i ++)
        {
            System.out.println(Heap.get(i).min_cost);
        }
    }
}

class Node{
    int x ;
    int y ;
    int min_cost ;

    public Node(){}
    public Node(int x , int y , int min_cost){
        this.x = x;
        this.y = y;
        this.min_cost = min_cost;
    }
}
