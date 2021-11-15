import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Arrays.sort() 메소드에 Comparator 구현

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] arr = new String[n];

		sc.nextLine();

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLine();
		}

		Arrays.sort(arr, new Comparator<String>() {
			
			// Compare 메소드의 리턴 값 3가지
			// 양의 정수 : 두 객체의 위치 바꿈
			// 0 : 변화 X
			// 음의 정수 : 변화 X
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) { // 단어 길이가 같을 때
					return s1.compareTo(s2); // 사전 순 정렬
				} else {
					return s1.length() - s2.length();
				}
			}
		});

		System.out.println(arr[0]);

		for (int i = 1; i < n; i++) {
			if (!arr[i].equals(arr[i - 1])) {
				System.out.println(arr[i]); // 단어가 중복될 경우 한 번만 출력
			}
		}
	}
}
