package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_22944 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, h, d;
	static boolean[] visited;
	static int sy, sx;
	static int ey, ex;
	static List<int[]> umb = new ArrayList<int[]>();
	static int ans;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		visited = new boolean[11];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				char c = s.charAt(j);
				if (c == 'S') {
					sy = i;
					sx = j;
				} else if (c == 'U') {
					umb.add(new int[] { i, j });
				} else if (c == 'E') {
					ey = i;
					ex = j;
				}
			}

		}

		ans = Integer.MAX_VALUE;
	}

	static void solve() {
		dfs(sy, sx, h, 0, 0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	static void dfs(int y, int x, int hp, int shield, int cnt) {
		if (Math.abs(ex - x) + Math.abs(ey - y) <= hp + shield) {
			ans = Math.min(ans, cnt + Math.abs(ex - x) + Math.abs(ey - y));
			return;
		}
		for (int i = 0; i < umb.size(); i++) {
			int dis = Math.abs(umb.get(i)[1] - x) + Math.abs(umb.get(i)[0] - y);
			if (hp + shield <= dis - 1 || visited[i])
				continue;
			if (shield < dis) {
				visited[i] = true;
				dfs(umb.get(i)[0], umb.get(i)[1], hp - (dis - shield), d, cnt + dis);
				visited[i] = false;
			} else {
				visited[i] = true;
				dfs(umb.get(i)[0], umb.get(i)[1], hp, d, cnt + dis);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
