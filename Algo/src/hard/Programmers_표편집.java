package hard;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Programmers_표편집 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n = 8;
	static int k = 7;
	static String[] cmd = { "C", "C", "C", "Z", "Z", "Z" };

	static String solution(int n, int k, String[] cmd) {
		Stack<Integer> stack = new Stack<Integer>();
		int size = n;
		for (int i = 0, c = cmd.length; i < c; i++) {
			String[] md = cmd[i].split(" ");
			if (md[0].equals("U")) {
				k -= Integer.parseInt(md[1]);
			} else if (md[0].equals("D")) {
				k += Integer.parseInt(md[1]);
			} else if (md[0].equals("C")) {
				stack.add(k);
				size--;
				if (k == size) {
					k--;
				}
			} else {
				if (stack.pop() <= k) {
					k++;
				}
				size++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append("O");
		}
		while (!stack.isEmpty()) {
			sb.insert(stack.pop(), "X");
		}

		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(n, k, cmd));
	}

	public class Node {
		int pre, cur, nxt;

		public Node(int pre, int cur, int nxt) {
			this.pre = pre;
			this.cur = cur;
			this.nxt = nxt;
		}
	}
}