import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UVa_10028 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		String[] table = {"`","1","2","3","4","5","6","7","8","9","0","-","=",
        							     "Q","W","E","R","T","Y","U","I","O","P","[","]","\\",
        							     "A","S","D","F","G","H","J","K","L",";","'",
        							     "Z","X","C","V","B","N","M",",",".","/"};
        ArrayList<String> map = new ArrayList<String>( Arrays.asList(table));
        String input,res;
        char[] c ;
		while(keyboard.hasNextLine()){
			input = keyboard.nextLine();
			c = input.toCharArray();
			res = "";
			for(int i = 0 ; i < input.length() ; i++){
				//System.out.println(map.indexOf(String.valueOf(c[i])));
				if(String.valueOf(c[i]).equals(" "))
					res = res + " ";
				else
					res = res + table[map.indexOf(String.valueOf(c[i]))-1];
			}
			System.out.println(res);
		}
		
	}

}
