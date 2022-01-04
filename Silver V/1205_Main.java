import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int score = sc.nextInt();
		int p = sc.nextInt(); // 랭킹에 올라갈 수 있는 점수의 개수

		int[] arr = new int[n]; // 리스트에 있는 점수

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int rank = 1;

		if (n == p && score <= arr[arr.length - 1]) {
			System.out.println(-1);
			
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (score < arr[i]) {
					rank++;
				} else {
					break;
				}
			}
			System.out.println(rank);
		}
	}
}
