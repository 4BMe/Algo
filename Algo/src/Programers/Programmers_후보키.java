package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Programmers_후보키 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
			{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
			{ "600", "apeach", "music", "2" } };
	static int ans = 0;
	static int r;
	static int c;
	static Map<Integer, Boolean> pKey = new HashMap<Integer, Boolean>();

	static int solve() {
		r = relation.length;
		c = relation[0].length;
		for (int k = 1, m = (1 << c + 1); k < m; k++) {
			find(k);
		}
		return ans;
	}

	static void find(int sum) {

		Map<String, Boolean> key = new HashMap<String, Boolean>();
		for (int i = 0; i < r; i++) {
			String s = "";
			for (int j = 0; j < c; j++) {
				if ((sum & (1 << j)) == 0) {
					continue;
				}
				s += relation[i][j];
			}
			if (key.containsKey(s)) {
				return;
			}
			key.put(s, true);
		}
		int size = pKey.entrySet().stream().filter(entry -> (entry.getKey() & sum) == entry.getKey())
				.collect(Collectors.toList()).size();
		if (size != 0) {
			return;
		}
		pKey.put(sum, true);
		ans++;
		return;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}