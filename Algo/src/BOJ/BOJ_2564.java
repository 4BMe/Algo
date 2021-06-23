package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2564 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int y, x, n;
	static int[] d = new int[2];
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		n = Integer.parseInt(br.readLine());
		map = new int[y + 1][x + 1];
		visited = new boolean[y + 1][x + 1];

		Arrays.fill(map[0], 1);
		Arrays.fill(map[y], 1);
		for (int i = 0; i < y; i++) {
			map[i][0] = 1;
			map[i][x] = 1;
		}

		int dir;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			dir = Integer.parseInt(st.nextToken());
			if (dir == 1) {
				map[y][Integer.parseInt(st.nextToken())] = 2;
			} else if (dir == 2) {
				map[0][Integer.parseInt(st.nextToken())] = 2;
			} else if (dir == 3) {
				map[y - Integer.parseInt(st.nextToken())][0] = 2;
			} else if (dir == 4) {
				map[y - Integer.parseInt(st.nextToken())][x] = 2;
			}
		}

		st = new StringTokenizer(br.readLine());
		dir = Integer.parseInt(st.nextToken());
		if (dir == 1) {
			d[0] = y;
			d[1] = Integer.parseInt(st.nextToken());
		} else if (dir == 2) {
			d[0] = 0;
			d[1] = Integer.parseInt(st.nextToken());
		} else if (dir == 3) {
			d[0] = y - Integer.parseInt(st.nextToken());
			d[1] = 0;
		} else if (dir == 4) {
			d[0] = y - Integer.parseInt(st.nextToken());
			d[1] = x;
		}
	}

	static void solve() {
//		for(int i=0; i<=y; i++) {
//			System.out.println();
//			for(int j=0; j<=x; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//		}
		bfs();
	}

	static void bfs() {
		int answer = 0;

		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { d[0], d[1], 0 });
		visited[d[0]][d[1]] = true;

		int[] cur;
		int ny, nx;
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int i = 0; i < 4; i++) {
				ny = cur[0] + dy[i];
				nx = cur[1] + dx[i];
				if (ny < 0 || ny > y || nx < 0 || nx > x || map[ny][nx] < 1 || visited[ny][nx])
					continue;
				q.offer(new int[] { ny, nx, cur[2] + 1 });
				visited[ny][nx] = true;
				if (map[ny][nx] == 2) {
					answer += cur[2] + 1;
				}
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
