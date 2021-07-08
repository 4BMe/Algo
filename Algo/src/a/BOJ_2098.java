package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2098 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static List<Integer>[] map;
	static int[][] dp;
	static int ans = Integer.MAX_VALUE;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());

		map = new List[n];
		for (int i = 0; i < n; i++)
			map[i] = new ArrayList<>(n);

		dp = new int[n][1 << (n + 1)];
		for (int i = 0; i < n; i++)
			Arrays.fill(dp[i], Integer.MAX_VALUE);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i].add(Integer.parseInt(st.nextToken()));
			}
		}

	}

	static void solve() {
		for (int i = 0; i < n; i++) {
			dfs(i, i, 1 << i, 0);
		}
	}

	static void dfs(int start, int now, int visited, int sum) {
		if (visited == (1 << (n + 1) - 1)) {
			ans = Math.min(ans, sum);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (map[now].get(i) == 0)
				continue;
			if (((1 << i) & visited) != 0)
				continue;
			dfs(start, i, visited + 1 << i, sum + map[now].get(i));
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
