import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 초기화
		ArrayDeque<Integer> q = new ArrayDeque<>();
		LinkedList<Integer> list[] = new LinkedList[n + 1];
		int[] arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new LinkedList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			arr[b]++;
		}

		for (int i = 1; i <= n; i++) {
			if (arr[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int current = q.pollLast();

			sb.append(current).append(" ");

			for (int num : list[current]) {
				arr[num]--;

				if (arr[num] == 0) {
					q.addLast(num);
				}

			}
		}
		System.out.println(sb.toString());
	}
}
