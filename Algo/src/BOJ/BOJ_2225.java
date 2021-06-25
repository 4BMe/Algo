package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2225 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, K;
	static int[][] dp;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[K + 1][N + 1];
		for (int i = 0; i <= K; i++) {
			dp[i][0] = 1;
		}
	}

	static void solve() {
		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000;
			}
		}

		System.out.println(dp[K][N]);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
