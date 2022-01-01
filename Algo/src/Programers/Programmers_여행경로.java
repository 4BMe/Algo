package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Programmers_여행경로 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
			{ "ATL", "SFO" } };
	static Map<String, List<String>> map = new HashMap<String, List<String>>();
	static Map<String, boolean[]> visited = new HashMap<String, boolean[]>();
	static List<String> ans = new LinkedList<>();
	static int size = 0;

	static String[] solution(String[][] tickets) {

		for (int i = 0, c = tickets.length; i < c; i++) {
			String from = tickets[i][0];
			String to = tickets[i][1];
			if (!map.containsKey(to)) {
				map.put(to, new ArrayList<String>());
			}
			List<String> conn = map.getOrDefault(from, new ArrayList<String>());
			conn.add(to);
			map.put(from, conn);
			size++;
		}

		for (String a : map.keySet()) {
			visited.put(a, new boolean[100001]);
		}

		List<String> start = map.get("ICN");
		String s = "ICN ";
		for (int i = 0, c = start.size(); i < c; i++) {
			boolean[] v = visited.get("ICN");
			v[i] = true;
			String next = start.get(i);
			dfs(1, next, s + next);
			v[i] = false;
		}

		Collections.sort(ans);
		return ans.get(0).split(" ");
	}

	static void dfs(int idx, String now, String s) {
		if (idx == size) {
			ans.add(s);
			return;
		}

		List<String> start = map.get(now);
		for (int i = 0, c = start.size(); i < c; i++) {
			boolean[] v = visited.get(now);
			if (v[i]) {
				continue;
			}
			v[i] = true;
			String next = start.get(i);
			dfs(idx + 1, next, s + " " + next);
			v[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		for (String a : solution(tickets)) {
			System.out.print(a + " ");
		}
	}

}