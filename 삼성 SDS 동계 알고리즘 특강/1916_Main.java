import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int node;
	int dist;

	public Node(int node, int dist) {
		this.node = node;
		this.dist = dist;
	}

	@Override
	public int compareTo(Node o) {
		return this.dist - o.dist;
	}

}

public class Main {
	public static void main(String[] args) throws IOException {

		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine()); // 정점 수
		int m = Integer.parseInt(br.readLine()); // 간선 수

		ArrayList<Node> list[] = new ArrayList[n + 1];
		int dis[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
			dis[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[a].add(new Node(b, c));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start, 0)); // 시작 위치
		dis[start] = 0;

		while (!q.isEmpty()) {
			Node now = q.poll();
			int nowTo = now.node; // 목적지
			int nowDist = now.dist; // 거리 비용

			if (nowDist > dis[nowTo]) {
				continue;
			}

			for (Node next : list[nowTo]) {
				if (nowDist + next.dist < dis[next.node]) {
					dis[next.node] = dis[nowTo] + next.dist;
					q.add(new Node(next.node, dis[next.node]));
				}
			}

		}

		sb.append(dis[end]);
		System.out.println(sb.toString());

	}
}
