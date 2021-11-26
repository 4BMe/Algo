package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_전화번호목록 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String[] phone_book = { "119", "97674223", "1195524421" };

	static boolean solve() {
		int len = phone_book.length;
		Arrays.sort(phone_book, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		List<Integer> size = new ArrayList<Integer>();
		HashMap<String, Boolean> pre = new HashMap<String, Boolean>();

		for (int i = 0; i < len; i++) {
			String now = phone_book[i];
			int nlen = now.length();
			for (int j = 0, c = size.size(); j < c; j++) {
				if (pre.containsKey(now.substring(0, size.get(j)))) {
					return false;
				}
			}
			pre.put(now, true);
			int s = size.size() - 1;
			if (s < 0 || size.get(s) != nlen) {
				size.add(now.length());
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}