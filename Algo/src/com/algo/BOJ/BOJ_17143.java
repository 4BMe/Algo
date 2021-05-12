package com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17143 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int y, x, m;
	static List<int[]>[][] shark;
	static int answer = 0;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		shark = new LinkedList[y][x];

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++)
				shark[i][j] = new LinkedList<>();
		}

		int r, c, s, d, z;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			shark[r][c].add(new int[] { s, d, z });
		}
	}

	static void solve() {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (shark[j][i].size() == 0)
					continue;
				answer += shark[j][i].get(0)[2];
				shark[j][i].remove(0);
				break;
			}
		}
	}

	static void moveShark() {
		Queue<int[]> q = new LinkedList<>();

		int[] cur;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (shark[i][j].size() == 0)
					continue;
				cur = shark[i][j].get(0);
				shark[i][j].remove(0);
				q.offer(new int[] { i, j, cur[0], cur[1], cur[2] });
			}
		}

		int[] s;
		while (!q.isEmpty()) {
			s = q.poll();
			if (s[3] == 0 || s[3] == 1) {
				s[3] = s[3] % ((y - 1) * 2);
			} else {
				s[3] = s[3] % ((x - 1) * 2);
			}
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
