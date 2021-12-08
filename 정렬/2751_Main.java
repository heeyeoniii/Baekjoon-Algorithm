import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// Arrays.sort() 메소드 
		// 평균 시간 복잡도가 O(nlongn)이지만 최악의 경우 O(n^2) -> 시간초과

		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
	
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list); // 오름차순 정렬
		
		for(int num : list) {
			sb.append(num).append('\n');
		}
		
		System.out.println(sb);
	}
}
