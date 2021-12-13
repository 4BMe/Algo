package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Programmers_프렌즈4블록 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int m = 6;
	static int n = 6;
	static String[] board = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" };
	static char[][] map;

	static int solve(int m, int n, String[] board) {
		map = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = board[i].charAt(j);
			}
		}

		int ans = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		while (true) {
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (map[i][j] == 0) {
						continue;
					}
					if (canDel(i, j)) {
						q.add(new int[] { i, j });
						q.add(new int[] { i + 1, j });
						q.add(new int[] { i, j + 1 });
						q.add(new int[] { i + 1, j + 1 });
					}
				}
			}
			if (q.isEmpty()) {
				break;
			}
			while (!q.isEmpty()) {
				int[] now = q.poll();
				if (map[now[0]][now[1]] != 0) {
					ans++;
					map[now[0]][now[1]] = 0;
				}
			}
			down();
		}
		return ans;
	}

	static void down() {
		for (int i = 0; i < n; i++) {
			for (int j = m - 1; j > 0; j--) {
				if (map[j][i] != 0) {
					continue;
				}
				int y = j;
				while (y > 0 && map[y][i] == 0) {
					y--;
				}
				if (map[y][i] == 0) {
					break;
				}
				map[j][i] = map[y][i];
				map[y][i] = 0;
			}
		}
	}

	static boolean canDel(int y, int x) {
		char c = map[y][x];
		if (y + 1 >= m || x + 1 >= n || map[y + 1][x] != c || map[y][x + 1] != c || map[y + 1][x + 1] != c) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(m, n, board));
	}

}