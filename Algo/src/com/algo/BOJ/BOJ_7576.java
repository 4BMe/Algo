package com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int m, n;
	static int[][] box;
	static int tomato;
	static int r = 0;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static Queue<int[]> t;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		box = new int[n][m];
		tomato = m * n;
		t = new LinkedList<int[]>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					r++;
					t.offer(new int[] { i, j });
				} else if (box[i][j] == -1)
					tomato--;
			}
		}

	}

	static void solve() {
		if (tomato == r) {
			System.out.println(0);
			return;
		}
		int day = 0;
		for (int i = 1;; i++) {
			if (bfs())
				day = i;
			else
				break;
		}
		if (tomato == r)
			System.out.println(day);
		else
			System.out.println(-1);
	}

	static boolean bfs() {
		int[] cur;
		int ny, nx;
		int temp = t.size();
		for (int i = 0; i < temp; i++) {
			cur = t.poll();
			for (int j = 0; j < 4; j++) {
				ny = cur[0] + dy[j];
				nx = cur[1] + dx[j];
//				System.out.println(ny+" "+nx);
				if (ny < 0 || ny >= n || nx < 0 || nx >= m || box[ny][nx] != 0)
					continue;
				t.offer(new int[] { ny, nx });
				box[ny][nx] = 1;
				r++;
			}
		}
//		System.out.println();
//		for (int i = 0; i < n; i++) {
//			System.out.println();
//			for (int j = 0; j < m; j++) {
//				System.out.print(box[i][j] + " ");
//			}
//		}

		if (t.isEmpty())
			return false;
		else
			return true;
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
