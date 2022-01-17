import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	static char[] data;
	static int L, C;
	static LinkedList<String> result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 실제 문제에서는 BufferedReader 사용

		// 파일 입출력
		// System.setIn(new FileInputStream("src/DAY01/파일명"));

		L = sc.nextInt();
		C = sc.nextInt();
		data = new char[C];
		result = new LinkedList<>();

		for (int i = 0; i < C; i++) {
			data[i] = sc.next().charAt(0);
		}

		Arrays.sort(data); // 체크인, 체크아웃 조건 생략 가능

		for (int i = 0; i < C; i++) {
			if (data[i] == 'a' || data[i] == 'e' || data[i] == 'i' || data[i] == 'o' || data[i] == 'u') {
				DFS(1, 0, 1, i, "" + data[i]);
			} else {
				DFS(1, 1, 0, i, "" + data[i]);
			}
		}

		for (String s : result) {
			System.out.println(s);
		}
	}

	static void DFS(int length, int ja, int mo, int current, String pwd) {
		// 1. 체크인 - 생략

		// 2. 목적지인가? - 길이(4글자) + 자음과 모음 개수
		if (length == L) {
			if (ja >= 2 && mo >= 1) {
				result.add(pwd);
			}

		} else {
			// 3. 연결된 곳 순회 - 나보다 높은 알파벳
			for (int i = current + 1; i < data.length; i++) {
				char next = data[i];

				// 4. 갈 수 있는가? - 생략
				// 5. 간다 - DFS(next) - 자음일때 vs 모음일때
				if (next == 'a' || next == 'e' || next == 'i' || next == 'o' || next == 'u') {
					DFS(length + 1, ja, mo + 1, i, pwd + next);

				} else {
					DFS(length + 1, ja + 1, mo, i, pwd + next);
				}
			}
		}
		// 6. 체크아웃 - 생략
	}
}
