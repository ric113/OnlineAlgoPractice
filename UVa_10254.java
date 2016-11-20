import java.util.Scanner;
import java.math.BigInteger;

public class UVa_10254 {
	
	static BigInteger new_homi[] = new BigInteger[10001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new_homi[0] = BigInteger.valueOf(0);
		new_homi[1] = BigInteger.valueOf(1);
		int count = 2 ;
		int count_temp = 0;
		for(int i = 2 ; i < 10001 ; i++){
			if(count == count_temp){
				count ++;
				count_temp = 0;
			}
			new_homi[i] = new_homi[i-1].add(BigInteger.valueOf(1).shiftLeft(count-1));
			count_temp++;
			
		}
		Scanner keyboard = new Scanner(System.in);
		int i ;
		while(keyboard.hasNextInt()){
			i = keyboard.nextInt();
			System.out.println(new_homi[i]);
			
		}
	}
	
	

}
