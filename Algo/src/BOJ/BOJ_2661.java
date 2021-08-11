package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2661 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[] visited;
	static String ans = "";

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		visited = new int[n];
		Arrays.fill(visited, Integer.MAX_VALUE);
	}

	static void solve() {
		dfs(1, "1");
		System.out.println(ans);
	}

	static void dfs(int idx, String s) {
		if (ans.length() == n)
			return;
		int len = s.length() / 2;
		for (int i = 1; i <= len; i++) {
			if (s.substring(idx - i, idx).equals(s.substring(idx - (i * 2), idx - i)))
				return;
		}
		if (idx == n) {
			ans = s;
			return;
		}

		for (int i = 1; i <= 3; i++) {
			if (s.charAt(idx - 1) - 48 == i)
				continue;
			dfs(idx + 1, s + String.valueOf(i));
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
