import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static int[] queue;
	public static int size = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> queue = new LinkedList<>();

		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			switch (st.nextToken()) {

			case "push":
				queue.offer(Integer.parseInt(st.nextToken()));
				break;

			case "pop":
				// poll() : 삭제할 원소가 없을 경우 null 반환
				Integer item = queue.poll();

				if (item == null) {
					sb.append(-1).append("\n");
				} else {
					sb.append(item).append("\n");
				}
				break;

			case "front":
				// peek() : 큐에 꺼낼 요소가 없을 경우 null 반환
				Integer it1 = queue.peek();

				if (it1 == null) {
					sb.append(-1).append("\n");
				} else {
					sb.append(it1).append("\n");
				}
				break;

			case "back":
				// peekLast() : 큐에 꺼낼 요소가 없을 경우 null 반환
				Integer it2 = queue.peekLast();

				if (it2 == null) {
					sb.append(-1).append("\n");
				} else {
					sb.append(it2).append("\n");
				}
				break;

			case "size":
				sb.append(queue.size()).append("\n");
				break;

			case "empty":
				if (queue.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;
			}
		}
		System.out.println(sb);
	}
}
