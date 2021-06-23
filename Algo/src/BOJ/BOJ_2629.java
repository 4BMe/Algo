package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2629 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int k;
	static int[] ch;
	static int[] g;
	static boolean[][] dp;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		ch = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			ch[i] = Integer.parseInt(st.nextToken());

		k = Integer.parseInt(br.readLine());
		g = new int[k];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++)
			g[i] = Integer.parseInt(st.nextToken());

		dp = new boolean[n + 1][55001];
	}

	static void solve() {
		go(0, 0);

		for (int i = 0; i < k; i++) {
			if (dp[n][g[i]]) {
				System.out.print("Y ");
				continue;
			}
			System.out.print("N ");
		}

	}

	static void go(int cnt, int weight) {
		if (dp[cnt][weight])
			return;
		dp[cnt][weight] = true;
		if (cnt == n)
			return;
		go(cnt + 1, weight + ch[cnt]);
		go(cnt + 1, weight);
		go(cnt + 1, Math.abs(weight - ch[cnt]));
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
