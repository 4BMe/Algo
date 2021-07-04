package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9935 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String origin = "";
	static String remove = "";
	static Stack<Character> stack = new Stack<>();

	static void init() throws Exception {
		origin = br.readLine();
		remove = br.readLine();
	}

	static void solve() {
		for (int i = 0; i < origin.length(); i++) {
			stack.push(origin.charAt(i));
			if (stack.size() < remove.length())
				continue;
			boolean flag = true;
			for (int j = 0; j < remove.length(); j++) {
				if (stack.get(stack.size() - remove.length() + j) != remove.charAt(j)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				for (int j = 0; j < remove.length(); j++)
					stack.pop();
			}
		}
		sb = new StringBuilder();
		for (char ch : stack)
			sb.append(ch);
		System.out.println(sb.length()>0?sb.toString():"FRULA");
	}
	
	

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
