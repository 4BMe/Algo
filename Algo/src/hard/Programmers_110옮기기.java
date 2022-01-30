package hard;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Programmers_110옮기기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String[] s = { "1011110", "01110", "101101111010" };

	static String[] solution(String[] s) {
		String[] ans = new String[s.length];
		StringBuilder sb;

		for (int i = 0, c = s.length; i < c; i++) {
			String str = s[i];
			Stack<Character> stack = new Stack<>();
			int cnt = 0;
			for (int j = 0; j < str.length(); j++) {
				char z = str.charAt(j);

				if (stack.size() >= 2) {
					char y = stack.pop();
					char x = stack.pop();

					if (x == '1' && y == '1' && z == '0') {
						cnt++;
						continue;
					} else {
						stack.push(x);
						stack.push(y);
						stack.push(z);
					}
				} else {
					stack.push(z);
				}
			}

			int idx = stack.size();
			boolean flag = false;
			sb = new StringBuilder();

			while (!stack.isEmpty()) {
				if (!flag && stack.peek() == '1') {
					idx--;
				} else if (!flag && stack.peek() == '0') {
					flag = true;
				}
				sb.insert(0, stack.pop());
			}

			if (cnt > 0) {
				while (cnt > 0) {
					sb.insert(idx, "110");
					idx += 3;
					cnt--;
				}
				ans[i] = sb.toString();
			} else {
				ans[i] = s[i];
			}
		}

		return ans;
	}

	public static void main(String[] args) throws Exception {
		for (String a : solution(s)) {
			System.out.println(a);
		}
	}

}