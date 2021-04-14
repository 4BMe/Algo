package com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {

	static class Shark {
		int y, x, size, eat;

		Shark(int y, int x, int size, int eat) {
			this.y = y;
			this.x = x;
			this.size = size;
			this.eat = eat;
		}
	}

	static class Food {
		int y, x, dist;

		Food(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "위치: " + y + " " + x + " 거리:" + dist;
		}
	}

	static int N;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int answer = 0;
	static Shark shark;
	static PriorityQueue<Food> food = new PriorityQueue<Food>(new Comparator<Food>() {
		public int compare(Food f1, Food f2) {
			if (f1.dist < f2.dist) {
				return -1;
			} else if (f1.dist == f2.dist) {
				if (f1.y < f2.y) {
					return -1;
				} else if (f1.y == f2.y) {
					if (f1.x < f2.x) {
						return -1;
					}
				}
			}
			return 1;
		}
	});

	static boolean bfs() {
		Queue<int[]> p = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		p.offer(new int[] { shark.y, shark.x, 0 });
		visited[shark.y][shark.x] = true;
		int y, x, ny, nx;

		while (!p.isEmpty()) {

			for (int size = 0, c = p.size(); size < c; size++) {
				int[] cur = p.poll();
				y = cur[0];
				x = cur[1];
				for (int i = 0; i < 4; i++) {
					ny = y + dy[i];
					nx = x + dx[i];
					if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx] || map[ny][nx] > shark.size)
						continue;
					visited[ny][nx] = true;
					if (map[ny][nx] > 0 && map[ny][nx] < shark.size) {
						food.offer(new Food(ny, nx, cur[2] + 1));
					}
					p.offer(new int[] { ny, nx, cur[2] + 1 });
				}
			}

			if (food.size() > 0)
				break;
		}
		if (food.size() > 0) {
			Food e = food.poll();
			map[e.y][e.x] = 0;
			shark.y = e.y;
			shark.x = e.x;
			shark.eat++;
			if (shark.eat == shark.size) {
				shark.size++;
				shark.eat = 0;
			}
			answer += e.dist;
			food.clear();
			p.clear();
			return true;
		} else
			return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Shark(i, j, 2, 0);
					map[i][j] = 0;
				}
			}
		}
		while (bfs()) {

		}
		System.out.println(answer);

	}

}
