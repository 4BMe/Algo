package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7579 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, m;
	static int[] mem, cost;
	static int ans;
	static int[][] dp;
	static int max = 0;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		mem = new int[n];
		cost = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			mem[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			max += cost[i];
		}

		dp = new int[n][max + 1];
		ans = 987654321;
	}

	static void solve() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= max; j++) {
				
			}
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
