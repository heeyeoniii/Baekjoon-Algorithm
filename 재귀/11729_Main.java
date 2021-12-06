import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		sb.append((int) (Math.pow(2, num) - 1)).append('\n'); // 하노이 공식 일반항

		hanoi(num, 1, 2, 3);
		System.out.println(sb);

	}

	public static void hanoi(int n, int start, int mid, int to) {
		// 하노이탑 점화식
		// Hanoi(n) = 2 * Hanoi(n-1) + 1

		if (n == 1) {
			sb.append(start + " " + to + "\n");
			return;
				
		} else {
			// n-1개를 A에서 B로 이동
			hanoi(n - 1, start, to, mid);
		}

		// 1개를 A에서 C로 이동
		sb.append(start + " " + to + "\n");

		// n-1개를 B에서 C로 이동
		hanoi(n - 1, mid, start, to);
	}

}
