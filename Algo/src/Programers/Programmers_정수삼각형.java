package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_정수삼각형 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };

	static int solve(int[][] triangle) {
		int ans = 0;
		int y = triangle.length;
		int[][] dp = new int[y][y];
		dp[0][0] = triangle[0][0];
		for (int i = 1; i < y; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == i) {
					dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
				} else if (j == 0) {
					dp[i][j] = triangle[i][j] + dp[i - 1][j];
				} else {
					dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
				}
			}
		}
		for (int i = 0; i < y; i++) {
			ans = Math.max(ans, dp[y - 1][i]);
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(triangle));
	}

}