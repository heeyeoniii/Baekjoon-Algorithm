import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int node;
	int cost;

	public Node(int node, int dist) {
		this.node = node;
		this.cost = dist;
	}

	@Override
	public int compareTo(Node o) {
		return (int) (this.cost - o.cost);
	}
}

public class Main {

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int v = Integer.parseInt(st.nextToken()); // 정점의 개수
		int e = Integer.parseInt(st.nextToken()); // 간선의 개수

		ArrayList<Node> list[] = new ArrayList[v + 1];
		int[] dist = new int[v + 1];

		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
			dist[i] = INF;
		}

		int k = Integer.parseInt(br.readLine()); // 시작 정점 번호
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // start
			int b = Integer.parseInt(st.nextToken()); // end
			int c = Integer.parseInt(st.nextToken()); // cost

			list[a].add(new Node(b, c));
		}

		PriorityQueue<Node> q = new PriorityQueue<>();
		dist[k] = 0;
		q.add(new Node(k, 0)); // 시작 위치

		while (!q.isEmpty()) {
			Node now = q.poll();

			if (now.cost > dist[now.node]) {
				continue;
			}

			for (Node next : list[now.node]) { // now와 연결된 Node들을 꺼냄
				if (now.cost + next.cost < dist[next.node]) {
					dist[next.node] = dist[now.node] + next.cost;
					q.add(new Node(next.node, dist[next.node]));
				}
			}

		}

		for (int i = 1; i <= v; i++) {
			if (dist[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}
}
