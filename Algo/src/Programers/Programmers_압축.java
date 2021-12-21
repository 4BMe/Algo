package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Programmers_압축 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String msg = "KAKAO";

	static int[] solve(String msg) {
		List<Integer> ans = new LinkedList<Integer>();
		Map<String, Integer> dic = new HashMap<>();
		int max = 26;
		for (int i = 1; i <= 26; i++) {
			char c = (char) ('A' + i - 1);
			String s = "" + c;
			dic.put(s, i);
		}

		int re = 0;
		for (int i = 0, c = msg.length(); i < c; i++) {
			String s;
			for (int j = i + 1; j <= c; j++) {
				s = msg.substring(i, j);
				if (!dic.containsKey(s)) {
					dic.put(s, ++max);
					ans.add(dic.get(msg.substring(i, j - 1)));
					i = j - 2;
					re = j - 1;
					break;
				}
				if (j == c) {
					ans.add(dic.get(msg.substring(i, c)));
					i = c;
				}
			}
		}

		return ans.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) throws Exception {
		for (int a : solve(msg)) {
			System.out.print(a + " ");
		}
	}

}