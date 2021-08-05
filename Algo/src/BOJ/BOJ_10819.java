package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[] num;
	static boolean[] visited;
	static int[] ch;
	static int ans = 0;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());

		num = new int[n];
		ch = new int[n];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void solve() {
		dfs(0);
		System.out.println(ans);
	}

	static void dfs(int cnt) {
		if (cnt == n) {
			int res = 0;
			for (int i = 1; i < n; i++) {
				res += Math.abs(ch[i - 1] - ch[i]);
			}
			ans = Math.max(ans, res);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			ch[cnt] = num[i];
			dfs(cnt + 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
