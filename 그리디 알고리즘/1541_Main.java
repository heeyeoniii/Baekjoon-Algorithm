import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		String[] minusArr = str.split("\\-"); // escape 처리

		int result = 0;

		for (int i = 0; i < minusArr.length; i++) {
			String[] plusArr = minusArr[i].split("\\+");

			for (int j = 0; j < plusArr.length; j++) {

				if (i == 0) {
					// -가 붙지 않은 부분
					result += Integer.parseInt(plusArr[j]);
				} else {
					result -= Integer.parseInt(plusArr[j]);
				}
			}
		}
		System.out.println(result);

	}
}
