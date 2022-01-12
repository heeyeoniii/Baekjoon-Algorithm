import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int n;
	static int[] ch;
	static ArrayList<ArrayList<Integer>> graph;
	static int count = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt(); // 컴퓨터 수
		int com = sc.nextInt(); // 연결된 컴퓨터 수(노드 수)
		ch = new int[n + 1];

		graph = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < com; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		BFS(1);
		System.out.println(count);

	}

	static void BFS(int L) {

		Queue<Integer> q = new LinkedList<>();
		ch[L] = 1;

		q.offer(L);

		while (!q.isEmpty()) {
			int tmp = q.poll();

			for (int i = 0; i < graph.get(tmp).size(); i++) {
				int num = graph.get(tmp).get(i);

				if (ch[num] == 0) {
					ch[num] = 1;
					count++;

					q.offer(num);
				}
			}

		}
	}
}
