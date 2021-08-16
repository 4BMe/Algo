package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_6987 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] res;
	static boolean[][] visited;
	static boolean[] done;
	static Map<String, Boolean> ch;

	static void init() throws Exception {
		ch = new HashMap<>();
		res = new int[6][3];
		visited = new boolean[6][6];
		done = new boolean[15];
	}

	static void solve() throws Exception {
		dfs(0);
		sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			sb.append(ch.containsKey(s) ? 1 : 0 + "\n");
		}
		System.out.println(sb);
	}

	static void dfs(int idx) {
		if (idx == 15) {
			sb = new StringBuilder();
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					sb.append(res[i][j] + " ");
				}
			}
			System.out.println(sb);
			ch.put(sb.toString().trim(), true);
			return;
		}

		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 6; j++) {
				if (visited[i][j])
					continue;
				visited[i][j] = true;
				visited[j][i] = true;
				// i 승
				res[i][0]++;
				res[j][2]++;
				dfs(idx + 1);
				res[i][0]--;
				res[j][2]--;

				// 무승
				res[i][1]++;
				res[j][1]++;
				dfs(idx + 1);
				res[i][1]--;
				res[j][1]--;

				// j 승
				res[i][2]++;
				res[j][0]++;
				dfs(idx + 1);
				res[i][2]--;
				res[j][0]--;
				visited[i][j] = false;
				visited[j][i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}
