import java.util.*;
import java.io.*;

public class UVa00105 {

	public static void main(String[] args)   throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] height = new int[10000];
		String line ;
		String ans = "";
		
		while ( (line= in.readLine()) != null){
			StringTokenizer stk = new StringTokenizer(line);
			int l = Integer.parseInt(stk.nextToken());
			int h = Integer.parseInt(stk.nextToken());
			int r = Integer.parseInt(stk.nextToken());
			
			if( l == 0)
				ans += "0";
				
			
			for(int i  = l ; i <r ;i++){
				height[i] = Math.max(h,height[i] );
			}
		}
			
			
			int temp = -1;
			for (int i = 1; i < height.length ; i++){
				if(temp !=height[i]){
					temp = height[i];
					if(!ans.equals("") && !ans.equals("0")){
						ans += " "+i+" "+height[i];
					}
					else
						ans +=i+" "+height[i];
				}
			}
			
			System.out.println(ans);
			in.close();
			System.exit(0);
			
		}
		
		

		

	}


