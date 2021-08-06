package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, m;
	static int[] num;
	static boolean[] vi;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		num = new int[n];
		vi = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);
	}

	static void solve() {
		sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			vi[i] = true;
			dfs(1, String.valueOf(num[i]));
			vi[i] = false;
		}
		System.out.println(sb);
	}

	static void dfs(int cnt, String s) {
		if (cnt == m) {
			sb.append(s + "\n");
			return;
		}
		for (int i = 0; i < n; i++) {
			if (vi[i]) {
				continue;
			}
			vi[i] = true;
			dfs(cnt + 1, s + " " + String.valueOf(num[i]));
			vi[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
