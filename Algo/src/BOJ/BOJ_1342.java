package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1342 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String s;
	static int ans;
	static boolean[] visited;
	static Map<Character, Integer> map = new HashMap<Character, Integer>();

	static void init() throws Exception {
		s = br.readLine();
		visited = new boolean[s.length()];
		ans = 0;
		for (int i = 0, c = s.length(); i < c; i++) {
			char ch = s.charAt(i);
			int cnt = map.getOrDefault(ch, 0);
			map.put(ch, cnt + 1);
		}
	}

	static void solve() {
		for (int i = 0, c = s.length(); i < c; i++) {
			visited[i] = true;
			dfs(String.valueOf(s.charAt(i)));
			visited[i] = false;
		}
		map.entrySet().forEach(entry -> {
			int fac = 1;
			for (int i = 2, c = entry.getValue(); i <= c; i++) {
				fac *= i;
			}
			ans /= fac;
		});
		System.out.println(ans);
	}

	static void dfs(String ss) {
		int len = ss.length();
		if (len == s.length()) {
			if (isLucky(ss)) {
				ans++;
			}
			return;
		}

		for (int i = 0, c = s.length(); i < c; i++) {
			if (visited[i] || s.charAt(i) == ss.charAt(len - 1))
				continue;
			visited[i] = true;
			dfs(ss + s.charAt(i));
			visited[i] = false;
		}
	}

	static boolean isLucky(String s) {
		for (int i = 0, c = s.length(); i < c - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1))
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}
