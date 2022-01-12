import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int n;
	static int m;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] ch;
	static int[] answer;
	static Queue<Integer> q;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		int v = sc.nextInt();
		graph = new ArrayList<ArrayList<Integer>>();
		ch = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		// 정점 번호가 작은 것을 먼저 방문하기 때문에
		for (ArrayList<Integer> node : graph) {
			Collections.sort(node);
		}

		DFS(v);
		Arrays.fill(ch, 0);
		System.out.println();
		BFS(v);

	}

	public static void DFS(int v) {
        
        if (ch[v] == 1) {
			return;
		}

		ch[v] = 1;

		System.out.print(v + " ");

		for (int num : graph.get(v)) {
			if (ch[num] == 0) {
				DFS(num);
			}
		}
	}

	public static void BFS(int v) {
		q = new LinkedList<Integer>();

		ch[v] = 1;
		q.offer(v);

		while (!q.isEmpty()) {
			int tmp = q.poll();
			System.out.print(tmp + " ");

			for (int i = 0; i < graph.get(tmp).size(); i++) {
				
				int num = graph.get(tmp).get(i);
				
				if (ch[num] == 0) {
					ch[num] = 1;
					q.offer(num);
				}
			}
		}
	}
}
