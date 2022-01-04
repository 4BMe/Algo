package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_자물쇠와열쇠 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] key = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
	static int[][] lock = { { 1, 1, 1 }, { 1, 0, 0 }, { 1, 1, 1 } };
	static List<int[]> empty;
	static List<int[]> fill;
	static int m;
	static int n;

	static boolean solution(int[][] key, int[][] lock) {
		empty = new ArrayList<int[]>();
		n = lock.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (lock[i][j] == 0) {
					empty.add(new int[] { i, j });
				}
			}
		}
		if (empty.size() == 0) {
			return true;
		}

		fill = new ArrayList<int[]>();
		m = key.length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if (key[i][j] == 1) {
					fill.add(new int[] { i, j });
				}
			}
		}
		if (fill.size() == 0) {
			return false;
		}

		for (int k = 0; k < 4; k++) {
			for (int i = 0, c = empty.size(); i < c; i++) {
				int[] cur = empty.get(i);
				for (int j = 0, w = fill.size(); j < w; j++) {
					int[] fkey = fill.get(j);
					int y = cur[0] - fkey[0];
					int x = cur[1] - fkey[1];
					if (match(y, x)) {
						return true;
					}
				}
			}
			rotate();
		}
		return false;
	}

	static boolean match(int y, int x) {
		int res = 0;
		for (int[] a : fill) {
			int ny = y + a[0];
			int nx = x + a[1];
			if (ny >= n || ny < 0 || nx >= n || nx < 0) {
				continue;
			}
			if (lock[ny][nx] != 0) {
				return false;
			}
			res++;
		}
		if (res == empty.size()) {
			return true;
		}
		return false;
	}

	static void rotate() {
		List<int[]> temp = new ArrayList<int[]>();
		for (int[] a : fill) {
			temp.add(new int[] { a[1], m - 1 - a[0] });
		}
		fill = temp;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(key, lock));
	}

}