package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Programmers_거리두기확인하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
			{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
			{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
	static int[][][] dist;
	static List<int[]> p;

	static int[] solve() {
		int[] ans = new int[5];
		for (int i = 0; i < 5; i++) {
			if (check(places[i])) {
				ans[i] = 1;
			}
		}
		return ans;
	}

	static boolean check(String[] place) {
		p = new ArrayList<int[]>();

		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (place[i].charAt(j) == 'P') {
					p.add(new int[] { i, j });
					cnt++;
				}
			}
		}
		Queue<int[]> q = new LinkedList<int[]>();
		dist = new int[cnt][5][5];

		int[] dy = { 0, 0, 1, -1 };
		int[] dx = { 1, -1, 0, 0 };

		for (int i = 0, c = p.size(); i < c; i++) {
			boolean[][] visited = new boolean[5][5];
			for (int j = 0; j < 5; j++) {
				Arrays.fill(dist[i][j], 100);
			}
			int[] f = p.get(i);
			q.add(new int[] { f[0], f[1] });
			visited[f[0]][f[1]] = true;
			dist[i][f[0]][f[1]] = 0;
			visited[f[0]][f[1]] = true;
			while (!q.isEmpty()) {
				int[] n = q.poll();
				for (int w = 0; w < 4; w++) {
					int ny = n[0] + dy[w];
					int nx = n[1] + dx[w];
					if (ny >= 5 || ny < 0 || nx >= 5 || nx < 0 || visited[ny][nx] || place[ny].charAt(nx) == 'X') {
						continue;
					}
					visited[ny][nx] = true;
					dist[i][ny][nx] = dist[i][n[0]][n[1]] + 1;
					q.add(new int[] { ny, nx });
				}
			}
		}

		for (int i = 0, c = p.size(); i < c; i++) {
			for (int j = i + 1; j < c; j++) {
				int[] f = p.get(i);
				int[] s = p.get(j);
				if (Math.abs(dist[i][f[0]][f[1]] - dist[i][s[0]][s[1]]) <= 2) {
					System.out.println(i + " " + f[0] + " " + f[1] + " : " + s[0] + " " + s[1]);
					for (int[] a : dist[i]) {
						for (int b : a) {
							System.out.print(b + " ");
						}
						System.out.println();
					}
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		for (int a : solve()) {
			System.out.print(a + " ");
		}
//		System.out.println(solve());
	}

}