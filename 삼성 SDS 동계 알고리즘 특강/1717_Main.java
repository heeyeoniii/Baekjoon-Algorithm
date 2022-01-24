import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;

	public static void main(String[] args) throws IOException {

		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 초기화
		arr = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			arr[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int cal = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (cal == 0) {
				// Union
				Union(a, b);

			} else if (cal == 1) {
				// Find
				if (Find(a) == Find(b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	static void Union(int a, int b) {
		int aRoot = Find(a);
		int bRoot = Find(b);

		arr[aRoot] = bRoot;
	}

	static int Find(int num) {

		if (arr[num] == num) {
			return num;

		} else {
			return arr[num] = Find(arr[num]);
		}
	}
}
