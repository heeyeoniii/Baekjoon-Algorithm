import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int lt = 0, rt = 0;
		long answer = Integer.MAX_VALUE;
		long sum = arr[0];

		while (true) {

			if (rt == N) {
				break;
			}

			if (sum >= S) {
				answer = Math.min(answer, (rt - lt) + 1);
				sum -= arr[lt++];

			} else {
				sum += arr[++rt];
			}

		}

		if (answer == Integer.MAX_VALUE) {
			System.out.println(0);

		} else {
			System.out.println(answer);
		}
	}
}
