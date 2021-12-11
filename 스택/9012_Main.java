import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			System.out.println(solve(sc.next()));
		}
	}

	public static String solve(String str) {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c == '(') {
				stack.push(c);
				
			} else if (stack.empty()) {
				return "NO";
				
			} else {
				stack.pop();
			}
		}

		if (stack.empty()) {
			return "YES";
			
		} else {
			return "NO";
		}
	}
}
