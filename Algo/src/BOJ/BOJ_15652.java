package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, m;
	static boolean[] c;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		c = new boolean[n + 1];

		sb = new StringBuilder();
	}

	static void solve() {
		for (int i = 1; i <= n; i++) {
			dfs(i, 1, String.valueOf(i));
		}
		System.out.println(sb);
	}

	static void dfs(int idx, int cnt, String s) {
		if (cnt == m) {
			sb.append(s + "\n");
			return;
		}
		if (idx > n) {
			return;
		}
		for (int i = idx; i <= n; i++) {
			dfs(i, cnt + 1, s + " " + String.valueOf(i));
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
