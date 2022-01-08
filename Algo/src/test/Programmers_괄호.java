package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Programmers_괄호 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String[] arr1 = {};
	static String[] arr2 = {};

	static List<String>[] list1 = new ArrayList[10];
	static List<String>[] list2 = new ArrayList[10];

	static long solution(String[] arr1, String[] arr2) {
		long ans = 0;
		long idx = 0;
		for (int i = 1; i < 10; i++) {
			list1[i] = new ArrayList<String>();
			list2[i] = new ArrayList<String>();
		}
		int[][] lefts = new int[10][2];
		for (int i = 0, c = arr1.length; i < c; i++) {
			int res = isComplete(arr1[i]);
			if (res == 10) {
				continue;
			}
			if (res == 0) {
				idx++;
			} else if (res > 0) {
				list1[res].add(arr1[i]);
			}
		}
		ans = idx;
		idx = 0;
		for (int i = 0, c = arr2.length; i < c; i++) {
			int res = isComplete(arr2[i]);
			if (res == 0) {
				idx++;
			} else if (res < 0) {
				list2[-res].add(arr2[i]);
			}
		}
		ans *= idx;
		for (int i = 1; i < 10; i++) {
			for (int j = 0, c = list1[i].size(); j < c; j++) {
				for (int k = 0, w = list2[i].size(); k < w; k++) {
					if (isComplete(list1[i].get(j) + list2[i].get(k)) == 0) {
						ans++;
					}
				}
			}
		}

		return ans;
	}

	static int isComplete(String s) {
		Stack<Character> st = new Stack<>();
		int close = 0;
		for (int i = 0, c = s.length(); i < c; i++) {
			if (s.charAt(i) == '(') {
				st.add('(');
			} else {
				if (st.isEmpty()) {
					close--;
				}
				st.pop();
			}
		}
		if (!st.isEmpty() && close < 0) {
			return 10;
		}
		if (!st.isEmpty()) {
			return st.size();
		}
		return close;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(arr1, arr2));
	}

}