package SWE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class swe_1249 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int t, n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];

		String s;
		for (int i = 0; i < n; i++) {
			s = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
	}

	static void solve() {
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}
		});
		q.offer(new int[] { 0, 0, 0 });
		visited[0][0] = true;
		int answer = Integer.MAX_VALUE;

		int cur[];
		int ny, nx;
		while (!q.isEmpty()) {
			cur = q.poll();
//			System.out.println(cur[0]+" "+cur[1]);
			for (int i = 0; i < 4; i++) {
				ny = cur[0] + dy[i];
				nx = cur[1] + dx[i];
				if (ny < 0 || ny >= n || nx < 0 || nx >= n || visited[ny][nx])
					continue;
				if (ny == n - 1 && nx == n - 1) {
					answer = Math.min(answer, cur[2]);
				} else {
					q.offer(new int[] { ny, nx, cur[2] + map[ny][nx] });
					visited[ny][nx] = true;
				}
			}
		}

		sb.append(answer + "\n");
	}

	public static void main(String[] args) throws Exception {

		t = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int test = 1; test <= t; test++) {
			sb.append("#" + test + " ");
			init();
			solve();
		}
		System.out.println(sb);
	}

}
