import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		System.out.println(Fibonacci(num));

	}

	static int Fibonacci(int n) {

		if (n <= 1) {
			return n;
		} else {
			return Fibonacci(n - 1) + Fibonacci(n - 2);
		}

	}

}
