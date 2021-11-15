import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 람다식
		// (매개변수1, ...) -> {함수;}

		// ex) a + b의 합
		// int c = (int a, int b) -> {return a + b};

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 점의 개수
		int[][] arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			
		}

		/*
		Arrays.sort(arr, new Comparator<int[]>() {		
			@Override
			public int compare(int[] e1, int[] e2) {
				if(e1[0] == e2[0]) {		// 첫번째 원소가 같다면 두 번째 원소끼리 비교
					return e1[1] - e2[1];
				}
				else {
					return e1[0] - e2[0];
				}
			}
		});
		*/

		Arrays.sort(arr, (e1, e2) -> {
			if (e1[0] == e2[0]) { 
				return e1[1] - e2[1];
			} else {
				return e1[0] - e2[0];
			}
		});

		for (int i = 0; i < n; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}
}
