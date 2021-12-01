package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Programmers_행렬테두리회전하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	static int[] solve() {
		int[][] queries = { { 2, 2, 5, 4 } };
		int rows = 6;
		int columns = 6;

		int[][] map = new int[rows + 1][columns + 1];
		int cnt = 1;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				map[i][j] = cnt;
				cnt++;
			}
		}
		int[] ans = new int[queries.length];
		for (int i = 0, c = queries.length; i < c; i++) {
			int y1 = queries[i][0];
			int x1 = queries[i][1];
			int y2 = queries[i][2];
			int x2 = queries[i][3];
			int start = map[y1][x1];
			cnt = rows * columns;
			cnt = Math.min(cnt, start);
			for (int y = y1; y < y2; y++) {
				map[y][x1] = map[y + 1][x1];
				cnt = Math.min(cnt, map[y][x1]);
			}
			for (int x = x1; x < x2; x++) {
				map[y2][x] = map[y2][x + 1];
				cnt = Math.min(cnt, map[y2][x]);
			}
			for (int y = y2; y > y1; y--) {
				map[y][x2] = map[y - 1][x2];
				cnt = Math.min(cnt, map[y][x2]);
			}
			for (int x = x2; x > x1; x--) {
				map[y1][x] = map[y1][x - 1];
				cnt = Math.min(cnt, map[y1][x]);
			}
			map[y1][x1 + 1] = start;
			ans[i] = cnt;
		}
		Arrays.sort(ans);
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}