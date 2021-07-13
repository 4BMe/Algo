package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2533 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[][] dp;
	static List<Integer>[] graph;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());

		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		dp = new int[n + 1][2];

	}

	static void solve() {
		dfs(1, -1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}

	static void dfs(int idx, int parent) {
		dp[idx][0] = 0;
		dp[idx][1] = 1;
		for (int next : graph[idx]) {
			if (next == parent)
				continue;
			dfs(next, idx);
			dp[idx][0] += dp[next][1];
			dp[idx][1] += Math.min(dp[next][0], dp[next][1]);
		}
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}
