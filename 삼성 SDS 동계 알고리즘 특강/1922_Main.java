import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int from;
	int to;
	int cost;

	public Node(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}

public class Main {

	static int[] arr;

	public static void main(String[] args) throws IOException {

		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine()); // 컴퓨터 수
		int m = Integer.parseInt(br.readLine());

		arr = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			arr[i] = i;
		}

		LinkedList<Node> list = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list.add(new Node(from, to, cost));
		}

		Collections.sort(list);

		int answer = 0;
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);

			if (count == n - 1) {
				break;
			}

			if (Find(arr[node.from]) != Find(arr[node.to])) {
				Union(arr[node.from], arr[node.to]);
				answer += node.cost;
				count++;
			}
		}
		sb.append(answer);
		System.out.println(sb.toString());
	}

	static void Union(int a, int b) {
		int aRoot = Find(a);
		int bRoot = Find(b);

		arr[aRoot] = bRoot;
	}

	static int Find(int num) {

		if (arr[num] == num) {
			return num;

		} else {
			return arr[num] = Find(arr[num]);
		}
	}
}
