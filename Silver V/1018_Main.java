import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt(); // 진짜 약수의 개수
		int arr[] = new int[num];
		int N = 0;
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;

		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt(); // 진짜 약수
		}

		for (int i = 0; i < num; i++) {
			if (arr[i] > min) {
				min = arr[i];
			}

			if (arr[i] < max) {
				max = arr[i];
			}
		}
		if (num == 1) {
			N = arr[0] * arr[0];
		} else {
			N = min * max;
		}

		System.out.println(N);

	}
}
