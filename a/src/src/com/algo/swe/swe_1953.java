package src.com.algo.swe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swe_1953 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, T, R, C, L;
	static int[][] map;
	static boolean[][] visited;
	static int answer;
	static Queue<int[]> q;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static boolean[][] status = { { true, true, true, true }, { true, false, true, false },
			{ false, true, false, true }, { true, true, false, false }, { false, true, true, false },
			{ false, false, true, true }, { true, false, false, true } };

	static void init() throws Exception {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		answer = 0;
		map = new int[N][M];
		visited = new boolean[N][M];
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		q.offer(new int[] { R, C });
	}

	static void bfs() {
		visited[R][C] = true;
		while (L-- > 0) {
			for (int size = 0, c = q.size(); size < c; size++) {
				int[] cur = q.poll();
				answer++;
				for (int i = 0; i < 4; i++) {
					int ny = cur[0] + dy[i];
					int nx = cur[1] + dx[i];
					int pipe = map[cur[0]][cur[1]];

					if (nx < 0 || ny < 0 || nx >= M || ny >= N)
						continue;
					if (!status[pipe - 1][i] || map[ny][nx] == 0 || visited[ny][nx])
						continue;
					int npipe = map[ny][nx];

					if (!status[npipe - 1][(i + 2) % 4])
						continue;
					q.offer(new int[] { ny, nx });
					visited[ny][nx] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		T = Integer.parseInt(in.readLine());

		for (int test = 1; test <= T; test++) {
			init();
			bfs();
			System.out.println("#" + test + " " + answer);
		}
	}

}
