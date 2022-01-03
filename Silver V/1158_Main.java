import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			q.add(i);
		}

		sb.append("<");
		
		while (q.size() > 1) {
			for (int i = 0; i < k - 1; i++) {
				int num = q.poll();
				q.offer(num);
			}

			sb.append(q.poll()).append(", ");
		}
		sb.append(q.poll()).append(">");
		
		System.out.println(sb);
	}
}
