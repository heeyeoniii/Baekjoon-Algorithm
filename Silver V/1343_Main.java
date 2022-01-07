import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		String pol1 = "AAAA";
		String pol2 = "BB";

		int count = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'X') {
				count++;

			} else {
				if (count % 2 == 1) {
					sb = new StringBuilder();
					sb.append(-1);
					break;
				}

				while (count != 0) {
					if (count >= 4) {
						sb.append(pol1);
						count -= 4;
					} else {
						sb.append(pol2);
						count -= 2;
					}
				}

				sb.append(".");
			}
		}

		if (count > 0) {
			if (count % 2 == 1) {
				sb = new StringBuilder();
				sb.append(-1);

			} else {

				while (count != 0) {
					if (count >= 4) {
						sb.append(pol1);
						count -= 4;
					} else {
						sb.append(pol2);
						count -= 2;
					}
				}
			}

		}

		System.out.println(sb);

	}
}
