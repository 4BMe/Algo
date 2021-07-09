package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5557 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[] num;
	static long[][] dp;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		num = new int[n + 1];
		dp = new long[n + 1][21];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			num[i] = Integer.parseInt(st.nextToken());

	}

	static void solve() {
		dp[1][num[1]]++;
		for (int i = 2; i < n; i++) {
			for (int j = 0; j < 21; j++) {
				if (dp[i - 1][j] == 0)
					continue;
				if (j + num[i] <= 20)
					dp[i][j + num[i]] += dp[i - 1][j];
				if (j - num[i] >= 0)
					dp[i][j - num[i]] += dp[i - 1][j];
			}
		}

		System.out.println(dp[n - 1][num[n]]);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
