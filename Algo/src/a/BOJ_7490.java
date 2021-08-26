package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7490 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int t;
	static int n;
	static boolean ch;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		ch = false;
	}

	static void solve() {
		dfs(1, "", false);
		if (ch)
			sb.append("\n");
	}

	static void dfs(int idx, String s, boolean ch) {
		s += idx;
		if (idx >= n) {
			calc(s);
			return;
		}
		if (!ch)
			dfs(idx + 1, s + " ", true);
		dfs(idx + 1, s + "+", false);
		dfs(idx + 1, s + "-", false);
	}

	static void calc(String s) {
		String temp = s.replace(" ", "");
		st = new StringTokenizer(temp, "+-");
		int[] num = new int[st.countTokens()];
		for (int i = 0, c = st.countTokens(); i < c; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int res = num[0];
		st = new StringTokenizer(temp, "123456789");
		for (int i = 0, c = st.countTokens(); i < c; i++) {
			if (st.nextToken().equals("+")) {
				res += num[i + 1];
			} else {
				res -= num[i + 1];
			}
		}
		if (res == 0) {
			ch = true;
			sb.append(s + "\n");
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
