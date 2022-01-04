import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 총 달걀 수
		int m = sc.nextInt(); // 고객 수
		int[] p = new int[m];

		for (int i = 0; i < m; i++) {
			p[i] = sc.nextInt();
		}

		Arrays.sort(p);

		int max = 0;
		int answer = 0, price = 0;

		for (int i = 0; i < m; i++) {
			
			if (m - i < n) {
				answer = p[i] * (m - i);
			} else {
				answer = p[i] * n;
			}

			if (max < answer) {
				price = p[i];
				max = answer;
			}
		}
		System.out.println(price + " " + max);

	}
}
