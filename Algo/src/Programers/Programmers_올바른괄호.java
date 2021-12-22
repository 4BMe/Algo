package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Programmers_올바른괄호 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String s = "";

	static boolean solve(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0, c = s.length(); i < c; i++) {
			char now = s.charAt(i);
			if (now == '(') {
				stack.push(now);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}

		if (!stack.isEmpty()) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(s));
	}

}