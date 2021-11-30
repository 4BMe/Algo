package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Programmers_짝지어제거하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	static int solve() {
		String s = "abcdefghijklmnopqrstuvwxyyxwvutsrqponmlkjihgfedcba";
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}

		return stack.isEmpty() ? 1 : 0;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}