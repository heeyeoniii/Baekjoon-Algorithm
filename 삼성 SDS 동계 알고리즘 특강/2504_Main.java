import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		String str = br.readLine();

		Stack<Character> stack = new Stack<>();
		int answer = 0;
		int mul = 1;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c == '(') {
				stack.push(c);
				mul *= 2;

			} else if (c == '[') {
				stack.push(c);
				mul *= 3;

			} else if (c == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					answer = 0;
					break;
				}

				if (str.charAt(i - 1) == '(') {
					answer += mul;
				}
				stack.pop();
				mul /= 2;

			} else if (c == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					answer = 0;
					break;
				}

				if (str.charAt(i - 1) == '[') {
					answer += mul;
				}
				stack.pop();
				mul /= 3;
			}
		}

		if (stack.isEmpty()) {
			System.out.println(answer);
		} else {
			System.out.println(0);
		}
	}
}
