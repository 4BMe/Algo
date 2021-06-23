package SWE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swe_1949 {

	static int N;
	static int K;
	static int[][] map;
	static boolean[][] visited;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int max = 0;
	static int answer;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	static void go(int y, int x, int idx, int k) {
		visited[y][x] = true;
		answer = Math.max(answer, idx);

		int ny, nx;
		int dif;
		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
				continue;
			}
			if (visited[ny][nx]) {
				continue;
			}
			if (map[ny][nx] < map[y][x]) {
				go(ny, nx, idx + 1, k);
			} else {
				dif = map[ny][nx] - map[y][x] + 1;
				if (dif > k)
					continue;
				map[ny][nx] -= dif;
				go(ny, nx, idx + 1, 0);
				map[ny][nx] += dif;
			}
		}
		visited[y][x] = false;
	}

	static void input() throws Exception {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > max)
					max = map[i][j];
			}
		}
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(in.readLine());

		for (int test = 1; test <= T; test++) {
			max = 0;
			answer = 0;
			input();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						visited = new boolean[N][N];
						go(i, j, 1, K);
					}
				}
			}
			System.out.println("#" + test + " " + answer);
		}

	}

}
