package src.com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_12865 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, k;
	static ArrayList<int[]> m = new ArrayList<>();
	static int[][] dp;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int w, v;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			m.add(new int[] { w, v });
		}
	}

	static void solve() {
		dp = new int[n][k + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				if (i == 0) {
					if (j - m.get(i)[0] >= 0)
						dp[i][j] = m.get(i)[1];
				} else {
					dp[i][j] = dp[i - 1][j];
					if (j - m.get(i)[0] >= 0) {
						dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - m.get(i)[0]] + m.get(i)[1]);
					}
				}
			}
		}
		System.out.println(dp[n - 1][k]);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
