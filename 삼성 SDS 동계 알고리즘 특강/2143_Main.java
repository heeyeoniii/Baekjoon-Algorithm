import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		int n = Integer.parseInt(br.readLine());
		int[] arr1 = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		int[] arr2 = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}

		// A의 부분합
		List<Integer> listA = new ArrayList<>();
		for (int i = 0; i < arr1.length; i++) {
			int tmp = arr1[i];
			listA.add(tmp);

			for (int j = i + 1; j < arr1.length; j++) {
				tmp += arr1[j];
				listA.add(tmp);
			}
		}

		// B의 부분합
		List<Integer> listB = new ArrayList<>();
		for (int i = 0; i < arr2.length; i++) {
			int tmp = arr2[i];
			listB.add(tmp);

			for (int j = i + 1; j < arr2.length; j++) {
				tmp += arr2[j];
				listB.add(tmp);
			}
		}

		Collections.sort(listA);
		Collections.sort(listB);

		int sizeA = listA.size();
		int sizeB = listB.size();
		int lt = 0;
		int rt = sizeB - 1;
		long sum = 0;
		long answer = 0;

		while (lt < sizeA && rt >= 0) {
			long countA = 0;
			long countB = 0;
			long sumA = listA.get(lt);
			long sumB = listB.get(rt);

			sum = sumA + sumB;

			if (sum < T) {
				lt++;

			} else if (sum > T) {
				rt--;

			} else if (sum == T) {
				while (lt < sizeA && listA.get(lt) == sumA) {
					lt++;
					countA++;
				}
				while (rt >= 0 && listB.get(rt) == sumB) {
					rt--;
					countB++;
				}
				answer += countA * countB;
			}

		}
		System.out.println(answer);
	}
}
