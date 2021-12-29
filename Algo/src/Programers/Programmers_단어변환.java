package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_단어변환 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String begin = "hit";
	static String target = "cog";
	static String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
	static boolean[] visited;
	static int ans = 0;

	static int solution(String begin, String target, String[] words) {
		int len = begin.length();
		visited = new boolean[words.length];
		dfs(begin, 0);
		return ans;
	}

	static void dfs(String s, int cnt) {
		if (s.equals(target)) {
			if (ans == 0) {
				ans = cnt;
			} else {
				ans = Math.min(ans, cnt);
			}
		}
		for (int i = 0, c = words.length; i < c; i++) {
			if (visited[i]) {
				continue;
			}
			int diff = 0;
			String next = words[i];
			for (int j = 0, w = s.length(); j < w; j++) {
				if (s.charAt(j) != next.charAt(j)) {
					diff++;
				}
			}
			if (diff > 1) {
				continue;
			}
			visited[i] = true;
			dfs(next, cnt + 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(begin, target, words));
	}

}