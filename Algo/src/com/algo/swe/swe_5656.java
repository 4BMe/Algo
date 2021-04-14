package com.algo.swe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swe_5656 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, y, x;
	static int[][] map;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0, };
	static int answer;
	static int blocks;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		blocks = 0;
		map = new int[y][x];
		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < x; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0)
					blocks++;
			}
		}
		answer = Integer.MAX_VALUE;
	}

	static void solve() {
		int[] line = new int[n];
		choose(0, line);
		sb.append(answer + "\n");
	}

	static void choose(int cnt, int[] line) {
		if (cnt == n) {
			int[][] temp = new int[y][x];
			copyMap(temp);

			cnt = 0;
			for (int i = 0; i < n; i++) {
				cnt += broke(line[i], temp);
				fillMap(temp);
			}
			answer = Math.min(answer, blocks - cnt);
			return;
		}

		for (int i = 0; i < x; i++) {
			line[cnt] = i;
			choose(cnt + 1, line);
		}
	}

	static void copyMap(int[][] temp) {
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				temp[i][j] = map[i][j];
			}
		}
	}

	static int broke(int spot, int[][] temp) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[y][x];
		for (int i = 0; i < y; i++) {
			if (temp[i][spot] != 0) {
				q.offer(new int[] { i, spot });
				visited[i][spot] = true;
				break;
			}
		}

		int cnt = 0;

		int[] cur;
		int ny, nx;
		while (!q.isEmpty()) {
			cur = q.poll();
			cnt++;
			for (int s = 1, c = temp[cur[0]][cur[1]]; s < c; s++) {
				for (int i = 0; i < 4; i++) {
					ny = cur[0] + dy[i] * s;
					nx = cur[1] + dx[i] * s;
					if (ny < 0 || ny >= y || nx < 0 || nx >= x || temp[ny][nx] == 0 || visited[ny][nx])
						continue;
					q.offer(new int[] { ny, nx });
					visited[ny][nx] = true;
				}
			}
			temp[cur[0]][cur[1]] = 0;
		}

		return cnt;
	}

	static void fillMap(int[][] temp) {
		for (int i = y - 1; i >= 0; i--) {
			for (int j = 0; j < x; j++) {
				if (temp[i][j] != 0)
					continue;
				for (int k = i - 1; k >= 0; k--) {
					if (temp[k][j] == 0)
						continue;
					temp[i][j] = temp[k][j];
					temp[k][j] = 0;
					break;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		int t = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int test = 1; test <= t; test++) {
			sb.append("#" + test + " ");
			init();
			solve();
		}
		System.out.println(sb);
	}

}
