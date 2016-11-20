import java.util.Scanner;

public class UVa_10285 {

	static int max;
	static int step;
	static int table[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		Scanner readline;

		int count = keyboard.nextInt();

		String name[] = new String[count];
		int rc[][] = new int[count][2];
		for (int i = 0; i < count; i++) {
			keyboard.nextLine();
			readline = new Scanner(keyboard.nextLine());
			name[i] = readline.next();
			rc[i][0] = readline.nextInt();
			rc[i][1] = readline.nextInt();
			max = 0;
			table = new int[rc[i][0] + 2][rc[i][1] + 2];

			for (int k = 0; k < rc[i][0] + 2; k++) {
				for (int j = 0; j < rc[i][1] + 2; j++) {
					if (k == 0 || j == 0 || k == rc[i][0] + 1
							|| j == rc[i][1] + 1)
						table[k][j] = 101;
					else
						table[k][j] = keyboard.nextInt();
				}
			}

			for (int k = 1; k <= rc[i][0]; k++) {
				for (int j = 1; j <= rc[i][1]; j++) {
					step = 0;
					dp(k, j);
				}
			}
			System.out.println(name[i] + ": " + max);

		}
	}

	static void dp(int r, int c) {
		step++;
		if (table[r][c] > table[r - 1][c])
			dp(r - 1, c);
		if (table[r][c] > table[r][c + 1])
			dp(r, c + 1);
		if (table[r][c] > table[r + 1][c])
			dp(r + 1, c);
		if (table[r][c] > table[r][c - 1])
			dp(r, c - 1);
		if (step > max)
			max = step;
		step = step - 1;

	}

}
