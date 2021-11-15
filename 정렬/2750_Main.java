import java.util.Arrays; // Arrays.sort()
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 내가 푼 코드 -> TreeSet 사용
		Set<Integer> set = new TreeSet<>();

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			set.add(sc.nextInt());
		}

		for (Integer i : set) {
			System.out.println(i);
		}

		// 버블 정렬
		// 첫 번째 인덱스부터 시작해 뒤의 인덱스들의 값들과 비교해 나가는 방법
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		
		// Arrays.sort()
		// 자바에서 기본으로 제공되는 메소드, 자동으로 해당 배열이 정렬되어 나온다.
		Arrays.sort(arr);
	}
}
