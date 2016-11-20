import java.util.Scanner;
public class UVa_11069 {

	static int table[] = new int[77];
	static boolean solve[] = new boolean[77];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		table[0] = 1;
		table[1] = 1;
		table[2] = 2;
		solve[1] = true;
		solve[2] = true;
		while(keyboard.hasNextInt()){
			int n = keyboard.nextInt();
			System.out.println(dp(n));
		}
	}
	
	public static int dp(int i){
		if( i==0 || i ==1)
			return table[1];
		else if(i==2)
			return table[2];
		else if(solve[i])
			return table[i];
		table[i] = dp(i-2)+dp(i-3);
		solve[i]=true;
		return table[i];
	}

}


