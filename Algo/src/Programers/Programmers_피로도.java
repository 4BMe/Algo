package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_피로도 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int k = 80;
	static int[][] dungeons = { { 80, 20 }, { 50, 40 }, { 30, 10 } };
	static int ans;
	static boolean[] visited = new boolean[9];
	static int len;

	static int solve(int k, int[][] dungeons) {
		ans = 0;
		len = dungeons.length;
		dfs(0, k);
		return ans;
	}

	static void dfs(int cnt, int pero) {
		ans = Math.max(ans, cnt);
		for (int i = 0; i < len; i++) {
			if (visited[i] || dungeons[i][0] > pero) {
				continue;
			}
			visited[i] = true;
			dfs(cnt + 1, pero - dungeons[i][1]);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(k, dungeons));
	}

}