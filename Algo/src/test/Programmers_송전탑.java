package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_송전탑 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] tower = {};
	static int k = 3;

	static int solution(int[][] tower, int k) {
		List<Integer>[] heights = new ArrayList[11];
		for (int i = 1; i < 11; i++) {
			heights[i] = new ArrayList<Integer>();
		}

		for (int i = 0, c = tower.length; i < c; i++) {
			heights[tower[i][1]].add(tower[i][0]);
		}

		int ans = 0;
		for (int i = 1; i < 11; i++) {
			if (heights[i].size() == 0) {
				continue;
			}
			int cnt = 1;
			int before = heights[i].get(0);
			for (int j = 1, c = heights[i].size(); j < c; j++) {
				int now = heights[i].get(j);
				if (now - before > k) {
					cnt++;
				}
				before = now;
			}
			ans += cnt;
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(tower, k));
	}

}