import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class  {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] cnt = new int[10001]; // 수 범위 : 0 ~ 10000

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			cnt[Integer.parseInt(br.readLine())]++; // 해당 인덱스 값 1 증가
		}

		br.close();

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < 10001; i++) {
			while (cnt[i] > 0) {
				sb.append(i).append('\n');
				cnt[i]--;
			}
		}
		System.out.println(sb);

	}
}
