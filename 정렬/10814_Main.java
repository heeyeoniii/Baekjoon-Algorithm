import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 방법 1. Comparator의 compare() 메소드 사용
		int n = sc.nextInt();
		String[][] arr = new String[n][2];

		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.next();
			arr[i][1] = sc.next();
		}

		Arrays.sort(arr, new Comparator<String[]>() {

			@Override
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			}

		});

		for (int i = 0; i < n; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}

		// 방법 2. 배열을 이용하지 않고 클래스 객체를 만들어 배열처럼 사용
		Person[] p = new Person[n];

		for (int i = 0; i < n; i++) {
			p[i] = new Person(sc.nextInt(), sc.next());
		}

		Arrays.sort(p, new Comparator<Person>() {

			@Override
			public int compare(Person s1, Person s2) {
				return s1.age - s2.age;
			}
		});

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			sb.append(p[i]);
		}
		System.out.println(sb);
	}

	public static class Person {
		int age;
		String name;

		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			return age + " " + name + "\n";
		}
	}
}
