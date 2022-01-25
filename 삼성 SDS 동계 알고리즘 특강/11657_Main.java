import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int to;
	int cost;

	public Node(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}

public class Main {

	static ArrayList<ArrayList<Node>> list;
	static long[] dist;
	static int n, m;
	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {

		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken()); // 도시의 개수
		m = Integer.parseInt(st.nextToken()); // 버스 노선의 개수

		list = new ArrayList<>();
		dist = new long[n + 1]; // 최단거리

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
			dist[i] = INF;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list.get(from).add(new Node(to, cost));
		}

		if (bellmanFord()) {
			sb.append("-1").append("\n");
		} else {
			for (int i = 2; i <= n; i++) {
				if (dist[i] == INF) {
					sb.append("-1").append("\n");
				} else {
					sb.append(dist[i] + "\n");
				}
			}
		}

		System.out.println(sb.toString());

	}

	static boolean bellmanFord() {
		dist[1] = 0;
		boolean update = false;

		for (int i = 1; i < n; i++) {
			update = false;

			for (int j = 1; j <= n; j++) {
				for (Node node : list.get(j)) {
					if (dist[j] == INF) {
						break;
					}

					if (dist[node.to] > dist[j] + node.cost) {
						dist[node.to] = dist[j] + node.cost;
						update = true;
					}
				}
			}

			if (!update) {
				break;
			}
		}

		if (update) {
			for (int i = 1; i <= n; i++) {
				for (Node node : list.get(i)) {
					if (dist[i] == INF) {
						break;
					}

					if (dist[node.to] > dist[i] + node.cost) {
						return true;
					}
				}
			}
		}

		return false;

	}

}
