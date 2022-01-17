import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	public int x, y;
	public char type;

	Point(int x, int y, char type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
}

public class Main {
	// DFS로 풀 수 있는 문제는 모두 BFS로 풀 수 있다.
	// 반대는 불가능 -> DFS는 동시에 움직이는 것을 처리할 수 없다.

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] dis;
	static char[][] arr;
	static int R, C;
	static boolean answer;
	static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		arr = new char[R][C];
		dis = new int[R][C];

		Point st = null;

		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
				
				if (arr[i][j] == 'S') {
					st = new Point(i, j, 'S');

				} else if (arr[i][j] == '*') {
					q.add(new Point(i, j, '*'));
				}
			}
		}

		q.add(st); // 고슴도치 Starting Point

		// BFS
		while (!q.isEmpty()) {
			// 1. 큐에서 꺼내옴
			Point p = q.poll();

			// 2. 목적지인가?
			if (p.type == 'D') {
				System.out.println(dis[p.x][p.y]);
				answer = true;
				break;
			}

			// 3. 연결된 곳 순회
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				// 4. 갈 수 있는가?
				if (ny >= 0 && ny < C && nx >= 0 && nx < R) {
					if (p.type == '.' || p.type == 'S') {
						// 고슴도치
						if ((arr[nx][ny] == '.' || arr[nx][ny] == 'D') && dis[nx][ny] == 0) {
							dis[nx][ny] = dis[p.x][p.y] + 1; // 5. 체크인
							q.add(new Point(nx, ny, arr[nx][ny])); // 6. 큐에 넣음
						}

					} else if (p.type == '*') {
						// 물
						if (arr[nx][ny] == '.') {
							arr[nx][ny] = '*'; // 5. 체크인
							q.add(new Point(nx, ny, '*')); // 6. 큐에 넣음
						}
					}

				}
			}
		}

		if (answer == false) {
			System.out.println("KAKTUS");
		}
	}
}
