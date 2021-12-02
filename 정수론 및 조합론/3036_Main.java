import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int firstLing = arr[0];

		for (int i = 1; i < n; i++) {

			int gcd = gcd(firstLing, arr[i]);

			System.out.println((firstLing / gcd) + "/" + arr[i] / gcd);
		}
	}

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;

		return gcd(b, a % b);
	}
}
