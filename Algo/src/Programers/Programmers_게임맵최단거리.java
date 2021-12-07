package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Programmers_게임맵최단거리 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	static boolean solve() {
		int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } };

		int y = maps.length;
		int x = maps[0].length;

		int[][] dist = new int[y][x];
		dist[0][0] = 1;

		int[] dy = { 0, 0, 1, -1 };
		int[] dx = { 1, -1, 0, 0 };

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { 0, 0 });

		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				if (ny < 0 || ny >= y || nx < 0 || nx >= x || maps[ny][nx] == 0 || dist[ny][nx] != 0) {
					continue;
				}
				q.add(new int[] { ny, nx });
				dist[ny][nx] = dist[now[0]][now[1]] + 1;
			}
		}
		System.out.println(dist[y - 1][x - 1]);
		return false;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}