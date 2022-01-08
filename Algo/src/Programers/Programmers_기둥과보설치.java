package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_기둥과보설치 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 5;
	static int[][] build_frame = { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 }, { 2, 2, 1, 1 }, { 5, 0, 0, 1 },
			{ 5, 1, 0, 1 }, { 4, 2, 1, 1 }, { 3, 2, 1, 1 } };
	static int[][] build_frame2 = { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 },
			{ 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 } };
	static int[][] map;

	static int[][] solution(int n, int[][] build_frame) {
		map = new int[n + 1][n + 1];
		for (int i = 0, c = build_frame.length; i < c; i++) {
			int[] now = build_frame[i];
			int y = now[1];
			int x = now[0];
			if (now[2] == 0) {
				if (now[3] == 1) {
					if (checkG(y, x)) {
						if ((map[y][x] & 1) == 0) {
							map[y][x] += 1;
						}
						if ((map[y + 1][x] & 2) == 0) {
							map[y + 1][x] += 2;
						}
					}
				} else {
					map[y][x] -= 1;
					map[y + 1][x] -= 2;
					if (poss(n)) {
						continue;
					}
					map[y][x] += 1;
					map[y + 1][x] += 2;
				}
			} else {
				if (now[3] == 1) {
					if (checkB(y, x)) {
						if ((map[y][x] & 4) == 0) {
							map[y][x] += 4;
						}
						if ((map[y][x + 1] & 8) == 0) {
							map[y][x + 1] += 8;
						}
					}
				} else {
					map[y][x] -= 4;
					map[y][x + 1] -= 8;
					if (poss(n)) {
						continue;
					}
					map[y][x] += 4;
					map[y][x + 1] += 8;
				}
			}
		}
		List<int[]> res = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (i != n && (map[i][j] & 1) == 1) {
					res.add(new int[] { j, i, 0 });
				}
				if (j != n && (map[i][j] & 4) == 4) {
					res.add(new int[] { j, i, 1 });
				}
			}
		}

		Collections.sort(res, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					if (o1[1] == o2[1]) {
						return o1[2] - o2[2];
					}
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		int[][] ans = new int[res.size()][3];
		for (int i = 0, c = res.size(); i < c; i++) {
			ans[i] = res.get(i);
		}
		return ans;
	}

	static boolean poss(int n) {
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if ((map[i][j] & 1) == 1 && checkG(i, j) == false)
					return false;
				else if ((map[i][j] & 4) == 4 && checkB(i, j) == false)
					return false;
			}
		}
		return true;
	}

	static boolean checkG(int y, int x) {
		if (y == 0 || (map[y][x] & 2) == 2 || ((map[y][x] & 8) == 8) || ((map[y][x] & 4) == 4)) {
			return true;
		}
		return false;
	}

	static boolean checkB(int y, int x) {
		if ((map[y][x] & 2) == 2 || (x + 1 <= n && (map[y][x + 1] & 2) == 2)
				|| ((map[y][x] & 8) == 8 && (map[y][x + 1] & 4) == 4)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(n, build_frame2));
	}

}