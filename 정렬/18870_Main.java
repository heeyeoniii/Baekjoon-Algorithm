import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] sort = arr.clone();
		Arrays.sort(sort);

		Map<Integer, Integer> map = new HashMap<>();

		int idx = 0;

		for (int n : sort) {
			if (!map.containsKey(n)) {
				map.put(n, idx++);
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int n : arr) {
			sb.append(map.get(n)).append(" ");
		}

		System.out.println(sb);

	}
}
