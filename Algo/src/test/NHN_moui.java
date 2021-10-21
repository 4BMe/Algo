package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class NHN_moui {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int sizeOfMatrix;
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static List<Integer> size;
	static int cnt = 0;

	static void init() throws Exception {
		sizeOfMatrix = Integer.parseInt(br.readLine());
		matrix = new int[sizeOfMatrix][sizeOfMatrix];
		visited = new boolean[sizeOfMatrix][sizeOfMatrix];
		size = new LinkedList<>();

		for (int i = 0; i < sizeOfMatrix; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < sizeOfMatrix; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void solve() {
		for (int i = 0; i < sizeOfMatrix; i++) {
			for (int j = 0; j < sizeOfMatrix; j++) {
				if (!visited[i][j] && matrix[i][j] == 1) {
					visited[i][j] = true;
					bfs(i, j);
				}
			}
		}
		System.out.println(cnt);
		Collections.sort(size);
		for (int i = 0; i < cnt; i++) {
			System.out.print(size.get(i) + " ");
		}
	}

	static void bfs(int y, int x) {
		cnt++;
		int res = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { y, x });

		while (!q.isEmpty()) {
			int[] now = q.poll();
			res++;
			for (int i = 0; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				if (ny < 0 || ny >= sizeOfMatrix || nx < 0 || nx >= sizeOfMatrix || matrix[ny][nx] == 0
						|| visited[ny][nx]) {
					continue;
				}
				visited[ny][nx] = true;
				q.add(new int[] { ny, nx });
			}
		}
		size.add(res);
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}