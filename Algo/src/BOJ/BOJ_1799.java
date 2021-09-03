package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1799 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[][] map;
	static List<int[]> black = new LinkedList<>();
	static List<int[]> white = new LinkedList<>();
	static int bSize;
	static int wSize;
	static boolean[] visited;
	static int bans;
	static int wans;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					if ((i + j) % 2 == 0)
						black.add(new int[] { i, j });
					else
						white.add(new int[] { i, j });
				}
			}
		}
		bSize = black.size();
		wSize = white.size();

		visited = new boolean[(n * 2 - 1) * 2];
		bans = 0;
		wans = 0;
	}

	static void solve() {
		blackDfs(0, 0);
		whiteDfs(0, 0);
		System.out.println(bans + wans);
	}

	static void blackDfs(int idx, int cnt) {
		if (idx == bSize) {
			bans = Math.max(bans, cnt);
			return;
		}
		int[] cur = black.get(idx);
		int left = (cur[0] - cur[1] + (n * 2 - 1)) % (n * 2 - 1);
		int right = cur[1] + cur[0] + n * 2 - 1;
		if (!visited[left] && !visited[right]) {
			visited[left] = true;
			visited[right] = true;
			blackDfs(idx + 1, cnt + 1);
			visited[left] = false;
			visited[right] = false;
		}
		blackDfs(idx + 1, cnt);
	}

	static void whiteDfs(int idx, int cnt) {
		if (idx == wSize) {
			wans = Math.max(wans, cnt);
			return;
		}
		int[] cur = white.get(idx);
		int left = (cur[0] - cur[1] + (n * 2 - 1)) % (n * 2 - 1);
		int right = cur[1] + cur[0] + n * 2 - 1;
		if (!visited[left] && !visited[right]) {
			visited[left] = true;
			visited[right] = true;
			map[cur[0]][cur[1]] = 2;
			whiteDfs(idx + 1, cnt + 1);
			map[cur[0]][cur[1]] = 1;
			visited[left] = false;
			visited[right] = false;
		}
		whiteDfs(idx + 1, cnt);
	}

	static void print() {
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
