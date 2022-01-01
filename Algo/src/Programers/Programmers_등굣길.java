package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Programmers_등굣길 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int m = 4;
	static int n = 3;
	static int[][] puddles = { { 2, 2 } };
	static int[][] dp;

	static int solution(int m, int n, int[][] puddles) {

		dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int i = 0, c = puddles.length; i < c; i++) {
			dp[puddles[i][1] - 1][puddles[i][0] - 1] = 0;
		}
		return dfs(0, 0) % 1000000007;
	}

	static int dfs(int y, int x) {
		if (y == n - 1 && x == m - 1) {
			return 1;
		}
		if (dp[y][x] != -1) {
			return dp[y][x] % 1000000007;
		} else {
			int res = 0;
			if (y < n - 1) {
				res += dfs(y + 1, x) % 1000000007;
			}
			if (x < m - 1) {
				res += dfs(y, x + 1) % 1000000007;
			}
			dp[y][x] = res % 1000000007;
			return dp[y][x];
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(m, n, puddles));
	}

}