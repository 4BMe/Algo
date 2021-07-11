package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9084 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int t, n, m;
	static int[] coin;
	static int[] dp;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		coin = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			coin[i] = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(br.readLine());
		dp = new int[m + 1];

	}

	static void solve() {
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			int c = coin[i - 1];
			for (int j = c; j <= m; j++) {
				dp[j] += dp[j - c];
			}
		}
		sb.append(dp[m] + "\n");
	}

	public static void main(String[] args) throws Exception {

		t = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			init();
			solve();
		}
		System.out.println(sb);
	}

}
