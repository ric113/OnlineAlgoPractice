import java.util.Scanner;
public class UVa_10128 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		int num =keyboard.nextInt();
		int ans[] = new int[num];
		int data[][] = new int[num][3];
		int dp[][][] = new int[14][14][14];
		
		for(int i = 0 ; i < num ; i++){
			for(int k = 0 ; k <3 ; k++){
				data[i][k] = keyboard.nextInt();
				
			}
			ans[i] = dpro(data[i][0],data[i][1],data[i][2]);
		}
		
		for(int i = 0 ; i < num ; i++){
			System.out.println(ans[i]);
		}
		
	}
	
	public static int dpro(int n,int p,int r){
		if(n == 1 && p == 1 && r == 1)
			return 1;
		if(n < p || n < r || p == 0 || r == 0)
			return 0;
		return dpro(n-1,p,r)*(n-2) + dpro(n-1,p-1,r) + dpro(n-1,p,r-1);
	}
	
	
	

}
