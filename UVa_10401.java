import java.util.ArrayList;
import java.util.Scanner;

public class UVa_10401 {

	/**
	 * @param args
	 */
	static int fib[] = new int[40];
	static ArrayList ans = new ArrayList();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i < 40; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}

		while (keyboard.hasNextInt()) {
			int num = keyboard.nextInt();
			int arr[] = new int[num];

			for (int i = 0; i < num; i++) {
				arr[i] = keyboard.nextInt();
				set(arr[i], 39, "");
				
			}
			for(int i = 0 ; i < num ; i ++){
				System.out.println(arr[i] + " = " + ans.get(i) + " (fib)");
			}

			ans.clear();

		}
	}

	static void set(int n, int index, String s) {
		if (n != 0 || index >= 2) {
			if (n - fib[index] >= 0) {
				s += "1";
				n -= fib[index];
				index--;
				set(n, index, s);
			} else {
				if (!s.equals("")) {
					s += "0";
					index--;
					set(n, index, s);
				} else {
					index--;
					set(n, index, s);
				}
			}
		} else
			ans.add(s);
	}

}
