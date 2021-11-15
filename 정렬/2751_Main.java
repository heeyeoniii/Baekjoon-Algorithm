import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}

		// java.util.Collections 클래스에서 제공하는 static 메소드 -> sort()		
		Collections.sort(list);

		
		for(int num : list) {
			sb.append(num).append('\n');
		}
		
		System.out.println(sb);

	}
}
