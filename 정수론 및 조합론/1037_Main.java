import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int num[] = new int[n];
		int answer = 0;

		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}

		Arrays.sort(num);
		
		if (n == 1) {
			answer = num[0] * num[0];
		} else {
			for (int i = 0; i < n; i++) {
				answer = num[0] * num[n-1];
			}
		}
		
		System.out.println(answer);

	}
}
