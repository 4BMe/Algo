package kakao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KAKAO6_2021 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	static int solve() {
		int[][] board = { { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 } };
		int[][] skill = { { 1, 0, 0, 3, 4, 4 }, { 1, 2, 0, 2, 3, 2 }, { 2, 1, 0, 3, 1, 2 }, { 1, 0, 1, 3, 3, 1 } };

		for (int i = 0, c = skill.length; i < c; i++) {
			int type = skill[i][0];
			int y1 = skill[i][1];
			int x1 = skill[i][2];
			int y2 = skill[i][3];
			int x2 = skill[i][4];
			int degree = skill[i][5];
			if (type == 1) {
				for (int y = y1; y <= y2; y++) {
					for (int x = x1; x <= x2; x++) {
						board[y][x] -= degree;
					}
				}
			} else {
				for (int y = y1; y <= y2; y++) {
					for (int x = x1; x <= x2; x++) {
						board[y][x] += degree;
					}
				}
			}
		}

		int ans = 0;
		for (int[] a : board)
			for (int b : a)
				if (b > 0)
					ans++;
		return ans;
	}

	public static void main(String[] args) throws Exception {

		System.out.println(solve());
	}

}
