/**
 * Created by ricky on 2016/9/5.
 */
import java.net.Inet4Address;
import java.util.Scanner;

public class UVa11463 {

    final static int BigValue = 99999999;

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int inputNum = keyboard.nextInt();
        int vertexCount;
        int edgcount;
        int v1,v2 ;
        int[][] vetexarr ;

        for(int c = 0 ; c < inputNum ; c++) {
            vertexCount = keyboard.nextInt();
            edgcount = keyboard.nextInt();
            vetexarr = new int[vertexCount][vertexCount];

            for(int i = 0 ; i < vertexCount ; i ++)
            {
                for (int j = 0 ; j < vertexCount ; j++)
                {
                    if( i == j)
                        vetexarr[i][j] = 0;
                    else
                        vetexarr[i][j] = BigValue;
                }
            }

            for(int e = 0 ; e < edgcount ; e ++)
            {
                v1 = keyboard.nextInt();
                v2 = keyboard.nextInt();

                vetexarr[v1][v2] = 1;
                vetexarr[v2][v1] = 1;
            }

            //showarr(vetexarr,vertexCount,vertexCount);

            v1 = keyboard.nextInt(); // start vertex
            v2 = keyboard.nextInt(); // end vertex

            for(int k = 0 ; k < vertexCount ; k ++) {
                for (int i = 0 ; i < vertexCount ; i ++){
                    for(int j = 0 ; j < vertexCount ; j ++)
                        vetexarr[i][j] = Math.min(vetexarr[i][j] , vetexarr[i][k] + vetexarr[k][j]);
                }
            }

            //showarr(vetexarr,vertexCount,vertexCount);

            int max = 0 ;
            for(int i = 0 ; i < vertexCount ; i ++){
                if(max < vetexarr[v1][i] + vetexarr[i][v2])
                    max = vetexarr[v1][i] + vetexarr[i][v2];
            }

            System.out.println("Case " + (c+1) + ": " + max );



        }


    }

    public static void showarr(int[][] arr , int row , int col)
    {
        for(int i = 0 ; i < row ; i ++){
            for(int j = 0 ; j < col ; j ++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }

}
