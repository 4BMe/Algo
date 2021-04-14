package com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static PriorityQueue<int[]> q;
	static int[] parent;
	static boolean[][] land;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void solve() {
		numbering();
		find_path();
	}

	static void numbering() {
		visited = new boolean[n][m];

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					cnt++;
					bfs(i, j, cnt);
				}
			}
		}

		parent = new int[cnt + 1];
		land = new boolean[cnt + 1][cnt + 1];

//		for (int i = 0; i < n; i++) {
//			System.out.println();
//			for (int j = 0; j < m; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//		}

	}

	static void bfs(int y, int x, int cnt) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { y, x });
		map[y][x] = cnt;
		visited[y][x] = true;

		int[] cur;
		while (!q.isEmpty()) {
			cur = q.poll();

			for (int i = 0; i < 4; i++) {
				y = cur[0] + dy[i];
				x = cur[1] + dx[i];
				if (y < 0 || y >= n || x < 0 || x >= m || visited[y][x] || map[y][x] == 0)
					continue;
				visited[y][x] = true;
				map[y][x] = cnt;
				q.offer(new int[] { y, x });

			}
		}
	}

	static void find_path() {

		q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}
		});

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0)
					dfs(i, j, map[i][j]);
			}
		}

		int cnt = parent.length;
		for (int i = 1; i < cnt; i++) {
			parent[i] = i;
		}
		cnt--;

		int ans = 0;
		for (int[] cur : q) {
			System.out.println(cur[0] + " " + cur[1] + " " + cur[2]);
			if (find(cur[0]) != find(cur[1])) {
//				System.out.println("연결");
				union(cur[0], cur[1]);
				cnt--;
				ans += cur[2];
			}
		}

		if (cnt == 1)
			System.out.println(ans);
		else
			System.out.println(-1);
	}

	static void dfs(int y, int x, int s) {

		int ny, nx, cnt;
		for (int i = 0; i < 4; i++) {
			ny = y;
			nx = x;
			cnt = 0;
			while (true) {
				ny += dy[i];
				nx += dx[i];
				cnt++;
				if (ny < 0 || ny >= n || nx < 0 || nx >= m || map[ny][nx] == s)
					break;
				if (map[ny][nx] == 0)
					continue;
				if (cnt >= 3) {
					q.offer(new int[] { s, map[ny][nx], cnt - 1 });
				}
				if (map[ny][nx] > 0)
					break;
				break;
			}
		}
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;
		else
			return parent[x] = find(parent[x]);
	}

	static void union(int y, int x) {
		y = find(y);
		x = find(x);
		if (x < y)
			parent[y] = x;
		else
			parent[x] = y;
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();

	}

}
