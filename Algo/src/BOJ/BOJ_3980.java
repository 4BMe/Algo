package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3980 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int t;
	static int[][] a;
	static boolean[] position;
	static int ans;

	static void init() throws Exception {
		a = new int[11][11];
		position = new boolean[11];

		for (int i = 0; i < 11; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 11; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
	}

	static void solve() {
		dfs(0, 0, 0);
		sb.append(ans+"\n");
	}

	static void dfs(int idx, int cnt, int sum) {
		if (cnt == 11) {
			ans = Math.max(ans, sum);
			return;
		}

		for (int j = 0; j < 11; j++) {
			if (position[j] || a[idx][j] == 0)
				continue;
			position[j] = true;
			dfs(idx + 1, cnt + 1, sum + a[idx][j]);
			position[j] = false;
		}
	}

	public static void main(String[] args) throws Exception {

		t = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			init();
			solve();
		}
		System.out.println(sb);
	}

}
