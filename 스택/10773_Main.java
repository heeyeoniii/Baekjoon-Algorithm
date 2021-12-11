import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static int[] stack;
	public static int size = 0; // 요소(데이터)의 개수

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		Stack<Integer> stack = new Stack<Integer>();

		int k = sc.nextInt();

		for (int i = 0; i < k; i++) {
			int num = sc.nextInt();

			if (num == 0) {
				stack.pop();
			} else {
				stack.push(num);
			}
		}

		int result = 0;

		for (int i : stack) {
			result += i;
		}

		System.out.println(result);

	}
}
