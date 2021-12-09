package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Programmers_괄호회전하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String s = "(((";

	static int solve(String s) {

		int ans = 0;
		for (int i = 0, c = s.length(); i < c; i++) {
			String temp = s.substring(i, c) + s.substring(0, i);
			if (right(temp)) {
				ans++;
			}
		}
		return ans;
	}

	static boolean right(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int j = 0, c = s.length(); j < c; j++) {
			char now = s.charAt(j);
			if (now == '(' || now == '[' || now == '{') {
				stack.add(now);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				if (now == ')') {
					if (stack.peek() != '(') {
						return false;
					}
				} else if (now == ']') {
					if (stack.peek() != '[') {
						return false;
					}
				} else {
					if (stack.peek() != '{') {
						return false;
					}
				}
				stack.pop();
			}
		}
		return stack.isEmpty() ? true : false;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(s));
	}

}