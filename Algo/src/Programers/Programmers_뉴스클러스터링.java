package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Programmers_뉴스클러스터링 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String str1 = "E=M*C^2";
	static String str2 = "e=m*c^2";

	static int solve() {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		String pattern = "[a-z]{2}";
		Map<String, int[]> key = new HashMap<String, int[]>();
		for (int i = 0, c = str1.length(); i < c - 1; i++) {
			String temp = str1.substring(i, i + 2);
			if (temp.matches(pattern)) {
				int[] def = { 0, 0 };
				def = key.getOrDefault(temp, def);
				def[0]++;
				key.put(temp, key.getOrDefault(temp, def));
			}
		}
		for (int i = 0, c = str2.length(); i < c - 1; i++) {
			String temp = str2.substring(i, i + 2);
			if (temp.matches(pattern)) {
				int[] def = { 0, 0 };
				def = key.getOrDefault(temp, def);
				def[1]++;
				key.put(temp, key.getOrDefault(temp, def));
			}
		}

		int sum = 0;
		int cnt = 0;
		Iterator<Map.Entry<String, int[]>> iteratorE = key.entrySet().iterator();
		while (iteratorE.hasNext()) {
			Map.Entry<String, int[]> entry = (Map.Entry<String, int[]>) iteratorE.next();
			int[] res = entry.getValue();
			sum += res[0] + res[1];
			cnt += Math.min(res[0], res[1]);
		}
		double res = sum == 0 ? 1 : ((double) cnt / (sum - cnt));
		int ans = (int) (65536 * res);
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}