import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		String str;

		while (true) {
			str = sc.nextLine();

			if (str.equals(".")) {
				break;
			}
			System.out.println(solve(str));
		}
	}

	public static String solve(String str) {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c == '[' || c == '(') {
				stack.push(c);

			} else if (c == ')') {
				if (stack.empty() || stack.peek() != '(') {
					return "no";
				} else {
					stack.pop();
				}

			} else if (c == ']') {
				if (stack.empty() || stack.peek() != '[') {
					return "no";
				} else {
					stack.pop();
				}
			}
		}

		if (stack.empty()) {
			return "yes";
		} else {
			return "no";
		}
	}
}
