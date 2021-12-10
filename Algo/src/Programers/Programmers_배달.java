package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Programmers_배달 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] road = { { 1, 2, 1 }, { 1, 3, 2 }, { 2, 3, 2 }, { 3, 4, 3 }, { 3, 5, 2 }, { 3, 5, 3 }, { 5, 6, 1 } };
	static int N = 6;
	static int K = 4;
	static List<Integer>[][] map;
	static boolean[] visited;
	static int[] dp;
	static Map<Integer, Boolean> poss = new HashMap<Integer, Boolean>();

	static int solve(int N, int[][] road, int K) {
		map = new ArrayList[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = new ArrayList<Integer>();
			}
		}
		for (int i = 0, c = road.length; i < c; i++) {
			int from = road[i][0];
			int to = road[i][1];
			int dist = road[i][2];
			if (map[from][to].size() > 0) {
				if (dist < map[from][to].get(0)) {
					map[from][to].remove(0);
					map[to][from].remove(0);
					map[from][to].add(dist);
					map[to][from].add(dist);
				}
			} else {
				map[from][to].add(dist);
				map[to][from].add(dist);
			}

		}
		visited = new boolean[N + 1];
		dp = new int[N + 1];
		Arrays.fill(dp, -1);
		visited[1] = true;
		dfs(1, 0);
		return poss.size();
	}

	static void dfs(int idx, int sum) {
		if (sum > K) {
			return;
		}
		if (dp[idx] != -1 && dp[idx] < sum) {
			return;
		}
		dp[idx] = sum;
		poss.put(idx, true);
		for (int i = 1; i <= N; i++) {
			if (visited[i] || map[idx][i].size() == 0) {
				continue;
			}
			visited[i] = true;
			dfs(i, sum + map[idx][i].get(0));
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(N, road, K));
	}

}