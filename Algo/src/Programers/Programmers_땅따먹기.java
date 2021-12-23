package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_땅따먹기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };

	static int solve(int[][] land) {
		int n = land.length;

		int[][] dp = new int[n][4];
		for (int i = 0; i < 4; i++) {
			dp[0][i] = land[0][i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				dp[i][j] = Math.max(dp[i - 1][(j + 1) % 4], Math.max(dp[i - 1][(j + 2) % 4], dp[i - 1][(j + 3) % 4]))
						+ land[i][j];
			}
		}
		int ans = 0;
		for (int a : dp[n - 1]) {
			ans = Math.max(ans, a);
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(land));
	}

}