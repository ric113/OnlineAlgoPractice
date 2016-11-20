// LCS Alg.

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_10066 {

	/**
	 * @param args
	 */
	static int[][] use_pos;
	static ArrayList LCS_s;
	static int[] t1;
	static int[] t2;
	static int[][] dparr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		int count = 1;
		int x, y;

		
		LCS_s = new ArrayList();

		while (keyboard.hasNextInt()) {
			x = keyboard.nextInt();
			y = keyboard.nextInt();
			if (x + y == 0)
				break;
			t1 = new int[x];
			t2 = new int[y];
			for (int i = 0; i < x; i++) {
				t1[i] = keyboard.nextInt();
			}
			for (int i = 0; i < y; i++) {
				t2[i] = keyboard.nextInt();
			}

			dparr = new int[x + 1][y + 1];
			use_pos = new int[x + 1][y + 1];

			int set = 0;

			while (set <= Math.max(x, y)) {
				if (set <= x)
					dparr[set][0] = 0;
				if (set <= y)
					dparr[0][set] = 0;
				set++;
			}

			for (int i = 1; i <= x; i++) {
				for (int j = 1; j <= y; j++) {
					if (t1[i - 1] == t2[j - 1]) {
						dparr[i][j] = dparr[i - 1][j - 1] + 1;
						use_pos[i][j] = 0;
					} else {
						dparr[i][j] = Math
								.max(dparr[i - 1][j], dparr[i][j - 1]);
						if (Math.max(dparr[i - 1][j], dparr[i][j - 1]) == dparr[i - 1][j])
							use_pos[i][j] = 1;
						else
							use_pos[i][j] = 2;
					}
				}
			}
			find_LCS(x, y);

			System.out.println("Twin Towers #" + count);
			System.out.println("Number of Tiles : " + dparr[x][y]);
			System.out.println(LCS_s);

			count++;

		}
	}

	static void find_LCS(int row, int col) {
		if (row > 0 && col > 0) {
			if (use_pos[row][col] == 0) {
				LCS_s.add(t1[row - 1]);
				find_LCS(row - 1, col - 1);
			} else if (use_pos[row][col] == 1)
				find_LCS(row - 1, col);
			else if (use_pos[row][col] == 2)
				find_LCS(row, col - 1);
		}

	}

}
