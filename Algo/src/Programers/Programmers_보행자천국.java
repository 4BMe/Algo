package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Programmers_보행자천국 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int m = 3;
	static int n = 6;
	static int[][] cityMap = { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } };
	static int[][][] dp;
	static int[] dy = { 0, 1 };
	static int[] dx = { 1, 0 };

	static public int solution(int m, int n, int[][] cityMap) {
		dp = new int[2][m][n];
		for (int i = 0; i < m; i++) {
			Arrays.fill(dp[0][i], -1);
			Arrays.fill(dp[1][i], -1);
		}


		int answer = dfs(0, 0, 0);
		return answer;
	}

	static int dfs(int y, int x, int dir) {
		if (y == m - 1 && x == n - 1) {
			return 1;
		}
		if (dp[dir][y][x] == -1) {
			dp[dir][y][x] = 0;
			if (cityMap[y][x] != 1) {
				int ny = dy[dir] + y;
				int nx = dx[dir] + x;
				if (ny >= 0 && ny < m && nx >= 0 && nx < n && cityMap[ny][nx] != 1) {
					dp[dir][y][x] += dfs(ny, nx, dir);
				}
				if (cityMap[y][x] == 0) {
					int ndir = (dir + 1) % 2;
					ny = dy[ndir] + y;
					nx = dx[ndir] + x;
					if (ny >= 0 && ny < m && nx >= 0 && nx < n && cityMap[ny][nx] != 1) {
						dp[dir][y][x] += dfs(ny, nx, ndir);
					}
				}
			}
		}

		return dp[dir][y][x];
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(m, n, cityMap));
	}

}