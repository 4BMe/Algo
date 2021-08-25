package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16938 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, l, r, x;
	static int[] diff;
	static boolean[] visited;
	static int ans = 0;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		diff = new int[n];
		visited = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			diff[i] = Integer.parseInt(st.nextToken());
	}

	static void solve() {
		dfs(0, 0, 0, 0, Integer.MAX_VALUE);
		System.out.println(ans);
	}

	static void dfs(int idx, int cnt, int sum, int max, int min) {
		if (sum > r) {
			return;
		}
		if (cnt >= 2) {
			if (sum >= l && max - min >= x) {
			ans++;
			}
		}

		for (int i = idx; i < n; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			dfs(i, cnt + 1, sum + diff[i], Math.max(max, diff[i]), Math.min(min, diff[i]));
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
