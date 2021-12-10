package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Programmers_위장 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
			{ "green_turban", "headgear" } };

	static int solve() {
		Map<String, Integer> cCnt = new HashMap<String, Integer>();
		for (int i = 0, c = clothes.length; i < c; i++) {
			String category = clothes[i][1];
			cCnt.put(category, cCnt.getOrDefault(category, 0) + 1);
		}

		int ans = 1;
		for (Entry<String, Integer> entry : cCnt.entrySet()) {
			ans *= entry.getValue() + 1;
		}
		return ans - 1;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}