package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Programmers_영어끝말잇기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 5;
	static String[] words = { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" };

	static int[] solve(int n, String[] words) {
		int[] ans = new int[2];
		Map<String, Boolean> h = new HashMap<String, Boolean>();
		h.put(words[0], true);
		char b = words[0].charAt(words[0].length() - 1);
		for (int i = 1, c = words.length; i < c; i++) {
			if (words[i].charAt(0) != b || h.containsKey(words[i])) {
				ans[0] = i % n + 1;
				ans[1] = i / n + 1;
				break;
			}
			h.put(words[i], true);
			b = words[i].charAt(words[i].length() - 1);
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		for (int a : solve(n, words)) {
			System.out.print(a + " ");
		}
	}

}