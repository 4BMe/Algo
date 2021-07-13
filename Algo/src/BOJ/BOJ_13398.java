package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13398 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[] num;
	static int[][] dp;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		dp = new int[n][2];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			num[i] = Integer.parseInt(st.nextToken());
	}

	static void solve() {
		int answer = num[0];
		dp[0][1] = num[0];
		for (int i = 1; i < n; i++) {
			dp[i][1] = Math.max(0, dp[i - 1][1]) + num[i];
			dp[i][0] = Math.max(dp[i - 1][0] + num[i], dp[i - 1][1]);
			answer = Math.max(answer, Math.max(dp[i][1], dp[i][0]));
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
