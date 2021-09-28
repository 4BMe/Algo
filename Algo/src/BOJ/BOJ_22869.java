package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_22869 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, k;
	static long[] jing;
	static long[] dp;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		jing = new long[n];
		dp = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			jing[i] = Long.parseLong(st.nextToken());
		}

		Arrays.fill(dp, 987654321);
		dp[0] = 0;
	}

	static void solve() {
		for (int j = 1; j < n; j++) {
			for (int i = 0; i < j; i++) {
				long power = (1L * (j - i) * (1 + Math.abs(jing[i] - jing[j])));
				if (power <= k) {
					dp[j] = Math.min(dp[j], dp[i] + power);
				}
			}
		}
		if (dp[n - 1] != 987654321) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}