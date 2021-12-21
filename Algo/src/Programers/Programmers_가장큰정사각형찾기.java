package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_가장큰정사각형찾기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] board = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };

	static int solve(int[][] board) {
		int ans = 0;
		int y = board.length;
		int x = board[0].length;
		int[][] dp = new int[y][x];
		for (int i = 0; i < y; i++) {
			dp[i][0] = board[i][0];
			ans = Math.max(ans, dp[i][0]);
		}
		for (int i = 0; i < x; i++) {
			dp[0][i] = board[0][i];
			ans = Math.max(ans, dp[0][i]);
		}
		for (int i = 1; i < y; i++) {
			for (int j = 1; j < x; j++) {
				if (board[i][j] == 0) {
					continue;
				}
				dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
				ans = Math.max(ans, dp[i][j]);
			}
		}

		return ans * ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(board));
	}

}