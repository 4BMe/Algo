package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16922 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[] num;
	static boolean[][] visited;
	static int ans;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		num = new int[] { 1, 5, 10, 50 };
		visited = new boolean[n + 1][n * 50 + 1];
		ans = 0;
	}

	static void solve() {
		for (int i = 0; i < 4; i++) {
			visited[1][num[i]] = true;
			dfs(1, num[i]);
		}
		System.out.println(ans);
	}

	static void dfs(int cnt, int sum) {
		if (cnt == n) {
			ans++;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (visited[cnt + 1][sum + num[i]])
				continue;
			visited[cnt + 1][sum + num[i]] = true;
			dfs(cnt + 1, sum + num[i]);
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
