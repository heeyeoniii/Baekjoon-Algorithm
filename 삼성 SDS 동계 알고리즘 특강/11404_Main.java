import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] arr = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			if (arr[start][end] == 0 || arr[start][end] > cost) {
				arr[start][end] = cost;
			}
		}

		for (int i = 1; i <= n; i++) { // 경유지
			for (int j = 1; j <= n; j++) { // 출발지
				for (int k = 1; k <= n; k++) { // 도착지

					if (j != k && arr[j][i] != 0 && arr[i][k] != 0) {
						if (arr[j][k] == 0 || arr[j][k] > arr[j][i] + arr[i][k]) {
							arr[j][k] = arr[j][i] + arr[i][k];
						}
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}
}
