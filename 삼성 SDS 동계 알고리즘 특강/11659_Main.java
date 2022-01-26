import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i < n + 1; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}

		dp[1] = arr[1];

		for (int i = 2; i < n + 1; i++) {
			dp[i] = dp[i - 1] + arr[i];
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			System.out.println(dp[b] - dp[a - 1]);
		}

	}
}
