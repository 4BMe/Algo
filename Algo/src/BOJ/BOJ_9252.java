package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9252 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String a;
	static String b;
	static int[][] dp;
	static Deque<Character> dq = new LinkedList<Character>();
	static Stack<Character> stack = new Stack<>();

	static void init() throws Exception {
		a = br.readLine();
		b = br.readLine();
		dp = new int[a.length() + 1][b.length() + 1];
	}

	static void solve() {
		int ans = 0;
		for (int i = 1, al = a.length(); i <= al; i++) {
			for (int j = 1, bl = b.length(); j <= bl; j++) {
				char ac = a.charAt(i - 1);
				char bc = b.charAt(j - 1);
				if (ac == bc) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					ans = Math.max(ans, dp[i][j]);
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		dfs(a.length(), b.length());
		System.out.println(ans);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}

	static void dfs(int y, int x) {
		if (y <= 0 || x <= 0)
			return;
		if (dp[y - 1][x] == dp[y][x] - 1 && dp[y][x - 1] == dp[y][x] - 1) {
			stack.push(a.charAt(y - 1));
			dfs(y - 1, x - 1);
		} else if (dp[y - 1][x] == dp[y][x]) {
			dfs(y - 1, x);
		} else if (dp[y][x - 1] == dp[y][x]) {
			dfs(y, x - 1);
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
