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
	static int ans;
	static int visited;
	static int start;
	static int[] dp;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());

		map = new List[n];
		for (int i = 0; i < n; i++)
			map[i] = new ArrayList<>(n);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		dp = new int[1 << (n + 1)];
		Arrays.fill(dp, Integer.MAX_VALUE);
	}

	static void solve() {
		for (int i = 0; i < n; i++) {
			ans = 0;
			start = i;
			dfs(i);
		}
	}

	static void dfs(int now) {
		if (dp[visited] < ans)
			return;
		dp[visited] = Math.min(dp[visited], ans);
		if (dp[visited ^ ((1 << (n + 1)) - 1)] > 0) {
			return;
		} else {
			for (int i = 0; i < n; i++) {
				if (map[now].get(i) == 0)
					continue;
				if (((1 << i) & visited) == 0)
					continue;
				visited += 1 << i;
				ans += map[now].get(i);
				dfs(now);
				visited -= 1 << i;
				ans -= map[now].get(i);
			}
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
