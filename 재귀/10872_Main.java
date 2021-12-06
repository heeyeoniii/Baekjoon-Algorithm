import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		
		System.out.println(factorial(num));

	}

	static int factorial(int n) {

		if (n <= 1) {
			return 1;
			
		} else {
			return factorial(n - 1) * n;
		}

	}
}
