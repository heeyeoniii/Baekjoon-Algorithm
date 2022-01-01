import java.io.IOException;
import java.util.Scanner;

public class Main {

	static int[][] dp = new int[30][30];

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			sb.append(comb(m, n)).append('\n');
		}

		System.out.println(sb);
	}

	static int comb(int n, int r) {
		if (dp[n][r] > 0) {
			return dp[n][r];
		}

		if (n == r || r == 0) {
			return dp[n][r] = 1;
		}

		return dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
	}
}
