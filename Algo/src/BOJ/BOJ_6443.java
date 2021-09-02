package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6443 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int t;
	static char[] s;
	static boolean[] visited;
	static int len;

	static void init() throws Exception {
		s = br.readLine().toCharArray();
		len = s.length;

		visited = new boolean[len];

		Arrays.sort(s);
	}

	static void solve() {
		dfs("", 0);
	}

	static void dfs(String res, int cnt) {
		if (cnt == len) {
			sb.append(res + "\n");
			return;
		}
		boolean[] alpha = new boolean[26];
		for (int i = 0; i < len; i++) {
			char c = s[i];
			if (visited[i] || alpha[c - 'a'])
				continue;
			alpha[c - 'a'] = true;
			visited[i] = true;
			dfs(res + c, cnt + 1);
			visited[i] = false;
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
