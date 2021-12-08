import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] cnt = new int[n];

		int sum = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}

		// 최빈값 구하기
		int mode_max = 0; // 최빈값의 최댓값
		int mode = 10000; // 최빈값
		boolean flag = false;

		for (int i = 0; i < n; i++) {
			int jump = 0;
			int count = 1;
			int i_value = arr[i];

			for (int j = i + 1; j < n; j++) {
				if (i_value != arr[j]) {
					break;
				}
				count++;
				jump++;
			}

			if (count > mode_max) {
				mode_max = count;
				mode = i_value;
				flag = true;
				
			} else if (count == mode_max && flag == true) {
				mode = i_value;
				flag = false;
			}
			i += jump;
		}

		Arrays.sort(cnt);

		System.out.println((int)Math.round((double)sum / n)); // 산술평균
		System.out.println(arr[n / 2]); // 중앙값
		System.out.println(mode); // 최빈값
		System.out.println(arr[n - 1] - arr[0]); // 최댓값 - 최솟값
	}
}
