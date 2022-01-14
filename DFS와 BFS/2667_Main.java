import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int n, answer, count;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < str.length(); j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				count = 1;
				if (arr[i][j] == 1) {
					answer++;
					arr[i][j] = 0;
					DFS(i, j);
					list.add(count);
				}
			}
		}

		System.out.println(answer); // 총 단지 수
		Collections.sort(list);
		for (int num : list) {
			System.out.println(num);
		}
	}

	public static void DFS(int x, int y) {

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 1) {
				arr[nx][ny] = 0;
				count++;
				DFS(nx, ny);
			}
		}
	}
}
