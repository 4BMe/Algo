package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_15663 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, m;
	static int[] num;
	static boolean[] visited;
	static Map<String, Boolean> ch = new HashMap<>();

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		num = new int[n];
		visited = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);
	}

	static void solve() {
		sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			visited[i] = true;
			dfs(i, 1, String.valueOf(num[i]));
			visited[i] = false;
		}

		System.out.println(sb);
	}

	static void dfs(int idx, int cnt, String s) {
		if (cnt == m) {
			if (ch.get(s) == null) {
				ch.put(s, true);
				sb.append(s + "\n");
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			dfs(i, cnt + 1, s + " " + String.valueOf(num[i]));
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
