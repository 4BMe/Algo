package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Programmers_이중우선순위큐 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String[] operations = { "I 7", "I 5", "I -5", "D -1" };

	static int[] solve(String[] operations) {
		int[] ans = { Integer.MIN_VALUE, Integer.MAX_VALUE };
		PriorityQueue<Integer> q = new PriorityQueue<>();

		for (int i = 0, c = operations.length; i < c; i++) {

			String[] s = operations[i].split(" ");
			if (s[0].equals("I")) {
				q.add(Integer.parseInt(s[1]));
			} else {
				if (q.isEmpty()) {
					continue;
				}
				int num = Integer.parseInt(s[1]);
				if (num == -1) {
					q.poll();
				} else {
					PriorityQueue<Integer> temp = new PriorityQueue<>();
					for (int j = 0, w = q.size(); j < w - 1; j++) {
						temp.add(q.poll());
					}
					q.poll();
					q = temp;
				}
			}

		}
		if (q.isEmpty()) {
			ans[0] = 0;
			ans[1] = 1;
			return ans;
		}
		while (!q.isEmpty()) {
			int a = q.poll();
			ans[0] = Math.max(a, ans[0]);
			ans[1] = Math.min(a, ans[1]);
		}

		return ans;
	}

	public static void main(String[] args) throws Exception {
		for (int a : solve(operations)) {
			System.out.print(a + " ");
		}
	}

}