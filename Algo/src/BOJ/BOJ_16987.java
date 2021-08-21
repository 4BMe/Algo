package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16987 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[] w;
	static int[] d;
	static boolean[][] visited;
	static int ans = 0;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		w = new int[n];
		d = new int[n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			d[i] = Integer.parseInt(st.nextToken());
			w[i] = Integer.parseInt(st.nextToken());
			visited[i][i] = true;
		}
	}

	static void solve() {
		dfs(0);
		System.out.println(ans);
	}

	static void dfs(int idx) {
		if (idx >= n) {
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (d[i] <= 0)
					cnt++;
			}
			if (ans < cnt)
				ans = cnt;
			return;
		}
		if (d[idx] <= 0)
			dfs(idx + 1);
		else {
			boolean Flag = false;
			for (int i = 0; i < n; i++) {
				if (i == idx || d[i] <= 0)
					continue;
				d[idx] -= w[i];
				d[i] -= w[idx];
				Flag = true;
				dfs(idx + 1);
				d[i] += w[idx];
				d[idx] += w[i];
			}
			if (Flag == false)
				dfs(n);
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
