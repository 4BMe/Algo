package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Programmers_괄호변환 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String p = "(()())()";

	static String solve() {

		return makeCorrect(p);

	}

	static String makeCorrect(String s) {
		int len = s.length();
		if (len == 0) {
			return "";
		}

		String u = "";
		String v = "";

		int open = 0;
		int close = 0;
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (c == '(') {
				open++;
			} else {
				close++;
			}
			if (open == close) {
				u = s.substring(0, i + 1);
				v = s.substring(i + 1, len);
				break;
			}
		}
		if (!isCorrect(v)) {
			v = makeCorrect(v);
		}
		if (!isCorrect(u)) {
			String temp = '(' + v + ')';
			String nu = u.substring(1, u.length() - 1);
			for (int i = 0, c = nu.length(); i < c; i++) {
				if (nu.charAt(i) == ')') {
					temp += '(';
				} else {
					temp += ')';
				}
			}
			return temp;
		}
		return u + v;
	}

	static boolean isCorrect(String s) {
		Stack<Character> st = new Stack<Character>();
		for (int i = 0, c = s.length(); i < c; i++) {
			char now = s.charAt(i);
			if (now == '(') {
				st.add(now);
			} else {
				if (st.isEmpty()) {
					return false;
				}
				st.pop();
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}