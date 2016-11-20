import java.util.Scanner;

public class UVa_11827 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		while (keyboard.hasNextInt()) {
			int num = keyboard.nextInt();
			keyboard.nextLine();
	
				for (int i = 0; i < num; i++) {
					String s = keyboard.nextLine();
					s = s.trim();
					String s_arr[] = s.split(" ");
					int max = 1;

					for (int k = 0; k < s_arr.length; k++) {
						for (int j = k + 1; j < s_arr.length; j++) {
							if (gcd(Integer.valueOf(s_arr[k]),
									Integer.valueOf(s_arr[j])) > max)
								max = gcd(Integer.valueOf(s_arr[k]),
										Integer.valueOf(s_arr[j]));
						}
					}
					System.out.println(max);
				}
			

			
		}
	}

	static int gcd(int x, int y) {
		if (y == 0)
			return x;
		return gcd(y, x % y);
	}

}
