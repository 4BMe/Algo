package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Programmers_경주로건설 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] board = { { 0, 1, 1 }, { 0, 0, 0 }, { 1, 1, 0 } };

	static int solution(int[][] board) {
		int n = board.length;
		int[][][] dp = new int[n][n][4];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		int[] dy = { 1, 0, -1, 0 };
		int[] dx = { 0, 1, 0, -1 };
		Queue<int[]> q = new LinkedList<int[]>();
		if (board[1][0] != 1) {
			q.add(new int[] { 1, 0, 0, 100 });
			dp[1][0][0] = 100;
		}

		if (board[0][1] != 1) {
			q.add(new int[] { 0, 1, 1, 100 });
			dp[0][1][1] = 100;
		}

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];
				if (ny < 0 || ny >= n || nx < 0 || nx >= n || board[ny][nx] == 1) {
					continue;
				}
				int cost = 100;
				if ((cur[2] % 2 == 0 && i % 2 == 1) || (cur[2] % 2 == 1 && i % 2 == 0)) {
					cost += 500;
				}
				cost += cur[3];
				if (dp[ny][nx][i] != -1 && dp[ny][nx][i] < cost) {
					continue;
				}
				dp[ny][nx][i] = cost;
				q.add(new int[] { ny, nx, i, cost });
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int a : dp[n - 1][n - 1]) {
			if (a != -1) {
				ans = Math.min(ans, a);
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(board));
	}

}