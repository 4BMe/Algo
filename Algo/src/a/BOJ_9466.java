package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9466 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int t, n;
	static int[] next;
	static boolean[] visited;
	static boolean[] done;
	static int cnt;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		next = new int[n + 1];
		visited = new boolean[n + 1];
		done = new boolean[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			next[i] = Integer.parseInt(st.nextToken());
		}

		cnt = 0;
	}

	static void solve() {
		for (int i = 1; i <= n; i++) {
			if (!done[i])
				dfs(i);
		}

		System.out.println(n-cnt);
	}

	static void dfs(int now) {
		if (visited[now]) {
			done[now] = true;
			cnt++;
		} else
			visited[now] = true;

		int ne = next[now];
		if (!done[ne])
			dfs(ne);
		
		visited[now]=false;
		done[now]=true;
		
	}

	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int test = 1; test <= t; test++) {
			init();
			solve();
		}
	}

}
