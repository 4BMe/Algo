package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_튜플 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

	static int[] solve() {
		StringTokenizer st = new StringTokenizer(s, "{}");
		List<String> tuple = new ArrayList<String>();

		for (int i = 0, c = st.countTokens(); i < c; i++) {
			String temp = st.nextToken();
			if (temp.length() == 1 && temp.charAt(0) == ',') {
				continue;
			}
			tuple.add(temp);
		}

		Collections.sort(tuple, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});

		List<Integer> ans = new LinkedList<Integer>();
		boolean[] check = new boolean[100001];
		for (String s : tuple) {
			st = new StringTokenizer(s, ",");
			for (int i = 0, c = st.countTokens(); i < c; i++) {
				int temp = Integer.parseInt(st.nextToken());
				if (check[temp]) {
					continue;
				}
				check[temp] = true;
				ans.add(temp);
			}
		}
		return ans.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) throws Exception {
		for (int a : solve()) {
			System.out.println(a);
		}
	}

}