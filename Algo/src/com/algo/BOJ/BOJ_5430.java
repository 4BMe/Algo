package com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_5430 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int t;
	static Deque<Integer> num;
	static String p;

	static void init() throws Exception {
		num = new LinkedList<>();

		p = br.readLine();

		br.readLine();

		st = new StringTokenizer(br.readLine(), "[],");
		for (int i = 0, c = st.countTokens(); i < c; i++)
			num.add(Integer.parseInt(st.nextToken()));
	}

	static void solve() {
		Character cur;
		boolean front = true;
		for (int i = 0, c = p.length(); i < c; i++) {
			cur = p.charAt(i);
			if (cur.equals('R')) {
				front = !front;
			} else {
				if (num.size() == 0) {
					sb.append("error\n");
					return;
				} else {
					if (front)
						num.pollFirst();
					else
						num.pollLast();
				}
			}
		}
		StringBuilder temp = new StringBuilder();
		temp.append("[");
		if (num.size() > 0) {
			while (!num.isEmpty()) {
				if (front)
					temp.append(num.pollFirst() + ",");
				else
					temp.append(num.pollLast() + ",");
			}
			temp.deleteCharAt(temp.length() - 1);
		}
		temp.append("]\n");
		sb.append(temp);
	}

	public static void main(String[] args) throws Exception {

		t = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int test = 1; test <= t; test++) {
			init();
			solve();
		}
		System.out.println(sb);
	}

}
