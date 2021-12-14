package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_삼각달팽이 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 100;
	static int[] dy = { 1, 0, -1 };
	static int[] dx = { 0, 1, -1 };
	static int[][] res;

	static int[] solve(int n) {
		res = new int[n][n];
		int y = 0;
		int x = 0;
		int dir = 0;
		int idx = 0;
		for (int i = n; i > 0; i--) {
			fill(y, x, idx + 1, i, dir);
			y += dy[dir] * (i - 1);
			x += dx[dir] * (i - 1);
			dir = (dir + 1) % 3;
			y += dy[dir];
			x += dx[dir];

			idx += i;
		}

		int[] ans = new int[idx];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (res[i][j] == 0) {
					continue;
				}
				ans[cnt] = res[i][j];
				cnt++;
			}
		}
		return ans;
	}

	static void fill(int y, int x, int idx, int cnt, int dir) {
		for (int i = 0; i < cnt; i++) {
			res[y + dy[dir] * i][x + dx[dir] * i] = idx++;
		}
	}

	public static void main(String[] args) throws Exception {
		for (int a : solve(n)) {
			System.out.print(a + " ");
		}
	}

}