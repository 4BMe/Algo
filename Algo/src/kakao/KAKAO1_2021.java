package kakao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class KAKAO1_2021 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String[] id_list = { "con", "ryan" };
	static String[] report = { "ryan con", "ryan con", "ryan con", "ryan con" };
	static int k;
	static boolean[][] check;
	static List<String>[] call;

	static void init() throws Exception {
		k = 2;
		call = new LinkedList[id_list.length];
		for (int i = 0, c = id_list.length; i < c; i++) {
			call[i] = new LinkedList<String>();
		}

		check = new boolean[id_list.length][id_list.length];
	}

	static void solve() {
		HashMap<String, Integer> id = new HashMap<String, Integer>();
		for (int i = 0, c = id_list.length; i < c; i++) {
			id.put(id_list[i], i);
		}

		for (int i = 0, c = report.length; i < c; i++) {
			st = new StringTokenizer(report[i]);
			String who = st.nextToken();
			int whoId = id.get(who);
			String to = st.nextToken();
			int toId = id.get(to);

			if (check[whoId][toId])
				continue;
			check[whoId][toId] = true;
			call[toId].add(who);
		}
		int[] ans = new int[id_list.length];

		for (int i = 0, c = id_list.length; i < c; i++) {
			if (call[i].size() < k)
				continue;
			for (int j = 0, w = call[i].size(); j < w; j++)
				ans[id.get(call[i].get(j))]++;
		}
		for (int a : ans) {
			System.out.print(a + " ");
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
