import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 브루트 포스 알고리즘 : 완전탐색(빠짐 없이)

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] card = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(search(card, n, m));

	}

	static int search(int[] arr, int n, int m) {
		int result = 0;

		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					int temp = arr[i] + arr[j] + arr[k];

					if (temp == m) return temp;

					if (result < temp && temp < m)
						result = temp;
				}
			}
		}
		return result;

	}
}
