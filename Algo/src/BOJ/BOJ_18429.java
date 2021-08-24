package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18429 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, k;
	static int[] num;
	static boolean[] visited;
	static int D = 500;
	static int ans = 0;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		num = new int[n];
		visited = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			num[i] = Integer.parseInt(st.nextToken());
	}

	static void solve() {
		dfs(0, 500);
		System.out.println(ans);
	}

	static void dfs(int day, int d) {
		if (day == n) {
			ans++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] || d + num[i] - k < 500)
				continue;
			visited[i] = true;
			dfs(day + 1, d + num[i] - k);
			visited[i] = false;

		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
