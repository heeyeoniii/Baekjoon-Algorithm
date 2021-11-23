import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int distance[] = new int[n - 1];
		int oil[] = new int[n];

		for (int i = 0; i < n - 1; i++) {
			distance[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			oil[i] = sc.nextInt();
		}

		int minCost = oil[0]; // 최소 비용
		int sum = 0;

		for (int i = 0; i < n - 1; i++) {

			if (oil[i] < minCost) {
				minCost = oil[i];
			}
			sum += (minCost * distance[i]);
		}
		System.out.println(sum);
	}
}
