package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12101 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, k;
	static int[] num = new int[] { 1, 2, 3 };
	static int ans = 0;
	static boolean find;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
	}

	static void solve() {
		if (k >= 504) {
			System.out.println(-1);
		} else {
			for (int i = 0; i < 3; i++) {
				dfs(i, num[i], String.valueOf(num[i]));
			}
			if (k > ans)
				System.out.println(-1);
		}
	}

	static void dfs(int idx, int sum, String s) {
		if (find)
			return;
		if (sum == n) {
			if (ans == k - 1) {
				System.out.println(s);
				find = true;
			}
			ans++;
			return;
		} else if (sum > n) {
			return;
		}

		for (int i = 0; i < 3; i++) {
			dfs(i, sum + num[i], s + "+" + String.valueOf(num[i]));
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
