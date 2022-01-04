import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		ArrayList<Integer> list = new ArrayList<>();

		int num = 1;
		int count = b;

		while (count > 0) {
			for (int i = 0; i < num; i++) {
				list.add(num);
			}
			num++;
			count--;
		}

		int answer = 0;

		for (int i = a - 1; i < b; i++) {
			answer += list.get(i);
		}
		
		System.out.println(answer);

	}
}
