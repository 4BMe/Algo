package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Programmers_더맵게 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	static int solve() {
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int k = 7;
		int cnt = 0;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for (int i = 0, c = scoville.length; i < c; i++) {
			q.add(scoville[i]);
		}

		while (q.peek() < k) {
			int f = q.poll();
			int s = q.poll();
			q.add(f + s * 2);
			cnt++;
		}

		return q.peek() < k ? -1 : cnt;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}