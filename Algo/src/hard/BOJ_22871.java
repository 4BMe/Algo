package hard;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_22871 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static long[] jing;
	static long[] dp;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		jing = new long[n];
		dp = new long[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			jing[i] = Long.parseLong(st.nextToken());
		}
		Arrays.fill(dp, -1);
	}

	static long go(int x) {
		if (x == n - 1)
			return 0;
		long ret = dp[x];
		if (ret != -1)
			return ret;
		ret = Long.MAX_VALUE;
		for (int i = x + 1; i < n; i++) {
			ret = Math.min(ret, Math.max(go(i), (i - x) * (1 + Math.abs(jing[i] - jing[x]))));
		}

		return dp[x] = ret;
	}

	static void solve() {
		System.out.println(go(0));
	}

	public static void main(String[] args) throws Exception {
		long beforeTime = System.currentTimeMillis();
		init();
		solve();
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime) / 1000;
		System.out.println("시간차이(m) : " + secDiffTime);
	}

}