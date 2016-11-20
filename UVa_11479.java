import java.util.Scanner;

public class UVa_11479 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in);
		int num = keyboard.nextInt();
		long tri[][] = new long[num][3];
		String res[] = new String[num];
		
		for(int i = 0 ; i < num ; i++){
			for(int j =  0 ; j < 3 ; j++){
				tri[i][j] = keyboard.nextLong();
			}
			res[i] = judge(tri[i][0],tri[i][1],tri[i][2]);
		}
		
		for(int i = 0 ; i < num ;i++){
			System.out.printf("Case %d: %s\n",i+1,res[i]);
		}
		
		
		
	}
	
	public static String judge(long a,long b,long c){
		long sum = a+b+c;
		if((a<=0 || b<=0 || c<=0) || sum-Math.max(Math.max(a,b),c) <= Math.max(Math.max(a,b),c))
			return "Invalid";
		if(Math.max(Math.max(a,b),c)  == Math.min(c,Math.min(a, b)))
				return "Equilateral";
		if((Math.max(Math.max(a,b),c)  != Math.min(c,Math.min(a, b)))&&(a==b || b==c || a==c))
			return"Isosceles";
		return"Scalene";
	
	}
	
	

}
