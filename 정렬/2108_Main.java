import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int sum = 0;

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());
			sum += list.get(i);
		}

		System.out.println(Math.round(sum / n)); // 산술평균
		// Math.round(num) : 소숫점 첫째자리에서 반올림

		Collections.sort(list);
		System.out.println(list.get(n / 2)); // 중앙값
		
		System.out.println(list.get(n - 1) - list.get(0)); // 최댓값 - 최솟값

	}
}
