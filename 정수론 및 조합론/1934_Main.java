import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		for (int i = 0; i < testCase; i++) {

			int num1 = sc.nextInt();
			int num2 = sc.nextInt();

			int d = gcd(num1, num2);

			if (d == 1) {
				System.out.println(num1 * num2);
			} else {
				System.out.println(num1 * num2 / d);
			}

		}
	}

	// 최대공약수 재귀 함수
	public static int gcd(int a, int b) {
		if (b == 0)
			return a;

		return gcd(b, a % b); // GCD(a, b) = GCD(b, r) 이므로 (r = a % b)
	}
}
