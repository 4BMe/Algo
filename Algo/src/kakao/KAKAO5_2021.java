package kakao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KAKAO5_2021 {

	static int[] info = { 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1 };
	static int[][] edges = { { 0, 1 }, { 1, 2 }, { 1, 4 }, { 0, 8 }, { 8, 7 }, { 9, 10 }, { 9, 11 }, { 4, 3 }, { 6, 5 },
			{ 4, 6 }, { 8, 9 } };

	static void solve() {
		int len = info.length;
		List<Integer>[] link = new ArrayList[len];
		for (int i = 0, c = len; i < c; i++) {
			link[i] = new ArrayList<Integer>();
		}

		for (int i = 0, c = edges.length; i < c; i++) {
			link[edges[i][0]].add(edges[i][1]);
		}

		int[] dp = new int[len];
		boolean[] visited = new boolean[len];

		Queue<Integer> poss = new LinkedList<Integer>();

		visited[0] = true;
		int sheep = 1;
		int wolf = 0;
		for (int j = 0, w = link[0].size(); j < w; j++) {
			int next = link[0].get(j);
			poss.add(next);
		}

		System.out.println(sheep);
	}

	static void dfs(int idx, int sheep, int wolf) {

	}

	public static void main(String[] args) throws Exception {

		solve();
	}

}
