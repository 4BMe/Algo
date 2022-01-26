package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Programmers_아이템줍기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] rectangle = { { 1, 1, 7, 4 }, { 3, 2, 5, 5 }, { 4, 3, 6, 9 }, { 2, 6, 8, 8 } };
	static int characterX = 1;
	static int characterY = 3;
	static int itemX = 7;
	static int itemY = 8;

	static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int[][] map = new int[105][105];
		for (int[] a : rectangle) {
			int leftY = a[1] * 2;
			int leftX = a[0] * 2;
			int rightY = a[3] * 2;
			int rightX = a[2] * 2;
			for (int i = leftX; i <= rightX; i++) {
				map[leftY][i] = 1;
				map[rightY][i] = 1;
			}
			for (int i = leftY; i <= rightY; i++) {
				map[i][leftX] = 1;
				map[i][rightX] = 1;
			}
		}
		boolean[][] v = new boolean[105][105];
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { 0, 0 });
		q.add(new int[] { 104, 104 });
		q.add(new int[] { 104, 0 });
		q.add(new int[] { 0, 104 });
		v[0][0] = v[104][0] = v[0][104] = v[104][104] = true;

		int[] dy = { 0, 0, 1, -1, 1, 1, -1, -1 };
		int[] dx = { 1, -1, 0, 0, 1, -1, 1, -1 };

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 8; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];
				if (ny < 0 || ny > 104 || nx < 0 || nx > 104 || v[ny][nx] || map[ny][nx] == 2) {
					continue;
				}
				if (map[ny][nx] == 1) {
					map[ny][nx] = 2;
					continue;
				}
				q.add(new int[] { ny, nx });
				v[ny][nx] = true;
			}
		}

		int ans = Integer.MAX_VALUE;
		characterY *= 2;
		characterX *= 2;
		itemY *= 2;
		itemX *= 2;
		q.add(new int[] { characterY, characterX, 0 });
		v[characterY][characterX] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];
				if (ny < 0 || ny > 104 || nx < 0 || nx > 104 || v[ny][nx] || map[ny][nx] != 2) {
					continue;
				}
				if (ny == itemY && nx == itemX) {
					ans = Math.min(ans, cur[2] + 1);
					continue;
				}
				q.add(new int[] { ny, nx, cur[2] + 1 });
				v[ny][nx] = true;
			}
		}

		return ans / 2;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(rectangle, characterX, characterY, itemX, itemY));
	}

}