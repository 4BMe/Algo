package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5582 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String s, t;
	static int[][] dp;

	static void init() throws Exception {
		s = br.readLine();
		t = br.readLine();
		dp = new int[s.length() + 1][t.length() + 1];
	}

	static void solve() {
		int ans = 0;
		for (int i = 1, sl = s.length(); i <= sl; i++) {
			for (int j = 1, tl = t.length(); j <= tl; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				ans = Math.max(ans, dp[i][j]);
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
