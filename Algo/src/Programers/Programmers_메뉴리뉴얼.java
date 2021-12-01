package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_메뉴리뉴얼 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String[] orders = { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" };
	static int[] course = { 2, 3, 5 };
	static int[] order;
	static boolean[] used = new boolean[26];
	static int[] max = new int[27];
	static List<String>[] ans = new ArrayList[27];

	static String[] solve() {
		int len = orders.length;
		order = new int[len];
		for (int i = 0; i < 27; i++) {
			ans[i] = new ArrayList<String>();
		}

		for (int i = 0; i < len; i++) {
			String s = orders[i];
			int o = 0;
			for (int j = 0, c = s.length(); j < c; j++) {
				int menu = s.charAt(j) - 'A';
				o += 1 << (menu);
				used[menu] = true;
			}
			order[i] = o;
		}

		for (int i = 0; i < 26; i++) {
			if (!used[i]) {
				continue;
			}
			for (int j = 0, c = course.length; j < c; j++) {
				dfs(i, 1, 1 << i, course[j]);
			}
		}
		List<String> res = new LinkedList<String>();
		for (List<String> s : ans) {
			if (s.size() == 0) {
				continue;
			}
			for (String t : s) {
				res.add(t);
			}
		}
		Collections.sort(res);
		for (String t : res) {
			System.out.println(t);
		}
		return res.stream().toArray(String[]::new);
	}

	static void dfs(int idx, int cnt, int sum, int goal) {
		if (cnt == goal) {
			int res = 0;
			for (int i = 0, c = order.length; i < c; i++) {
				if ((order[i] & sum) == sum) {
					res++;
				}
			}
			if (res >= 2) {
				int gmax = max[goal];
				String s = "";
				for (int i = 0; i < 26; i++) {
					if (((1 << i) & sum) == (1 << i)) {
						char c = (char) ('A' + i);
						s += c;
					}
				}
				if (res == gmax) {
					ans[goal].add(s);
				} else if (res > gmax) {
					ans[goal] = new ArrayList<String>();
					ans[goal].add(s);
					max[goal] = res;
				}
			}
			return;
		}

		for (int i = idx + 1; i < 26; i++) {
			if (!used[i]) {
				continue;
			}
			dfs(i, cnt + 1, sum + (1 << i), goal);
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}