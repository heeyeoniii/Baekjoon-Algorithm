import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();

		int stick = 64;
		int count = 0;

		while (x > 0) {
			if (stick > x) {
				stick /= 2;
			} else {
				x -= stick;
				count++;
			}
		}

		System.out.println(count);

	}
}
