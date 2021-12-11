import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static int[] stack;
	public static int size = 0; // 요소(데이터)의 개수

	public static void main(String[] args) throws IOException {
		// Java에서 제공하는 Stack 라이브러리는 Vector 클래스를 상속받아 구현되고 있다.

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();

		stack = new int[n];

		for (int i = 0; i < n; i++) {
			String str = sc.next();

			switch (str) {
			case "push":
				push(sc.nextInt());
				break;

			case "pop":
				sb.append(pop()).append('\n');
				break;

			case "size":
				sb.append(size()).append('\n');
				break;

			case "empty":
				sb.append(empty()).append('\n');
				break;

			case "top":
				sb.append(top()).append('\n');
				break;
			}
		}
		System.out.println(sb);
	}

	public static void push(int item) {
		stack[size] = item;
		size++;
	}

	public static int pop() {
		if (size == 0) {
			return -1;
		} else {
			int res = stack[size - 1];
			size--;
			return res;
		}
	}

	public static int size() {
		return size;
	}

	public static int empty() {
		if (size == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public static int top() {
		if (size == 0) {
			return -1;
		} else {
			return stack[size - 1];
		}
	}
}
