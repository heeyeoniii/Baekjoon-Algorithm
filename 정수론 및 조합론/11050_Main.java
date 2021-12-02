import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  
       /*
       * 이항 계수(Binomial coefficient) : 두 개의 항을 전개하여 계수로 나타낸 것
       * = (a + b)^n을 전개하였을 때의 계수
       * = b가 n개 있을 때 이들 중 r개를 뽑는 것
       * = nCr
       * = n! / r!(n - r)!
       */
      
       /*
       *** 알고리즘 1.
       * 
       * main {
       *    (factorial(N) / (factorial(K) * factorial(N-K)));
       * }
       * 
       * int factorial(int N) {
       *    if(N == 0) return 1;
       *    
       * return N * factorial(N - 1);
       * }
       * 
       *** 알고리즘 2. -> 파스칼의 법칙 & 'nC0 = nCn = 1' 이용
       * main { print(BC(N, K)); }
       * 
       * int BC(int N, int K) {
       * 
       *    if(N == K || K == 0) {
       *       return 1;
       *  }
       *  
       *  return BC(N - 1, K - 1) + BC(N - 1, K);
       *  
       *** 알고리즘 3. -> 동적계획법 이용
       * 
       * int[][] dp = new int[N + 1][K + 1];
       * 
       * main { print(BC(N, K)); }
       * 
       * int BC(int N, int K) {
       * 
       *    if(dp[N][K] > 0) return dp[N][K];
       *    
       *    if(N == K || K == 0) return dp[N][K] = 1;
       * 
       * return dp[N][K] = BC(N - 1, K - 1) + BC(N - 1, K);
       */

	static int[][] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		dp = new int[n + 1][k + 1];

		System.out.println(BC(n, k));
	}

	static int BC(int n, int k) {

		if (dp[n][k] > 0) {
			return dp[n][k];
		}

		if (k == 0 || n == k) {
			return dp[n][k] = 1;
		}

		return dp[n][k] = BC(n - 1, k - 1) + BC(n - 1, k);
	}

}
