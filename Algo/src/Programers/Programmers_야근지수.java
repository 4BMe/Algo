package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Programmers_야근지수 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 4;
	static int[] works = { 4, 3, 3 };

	static long solution(int n, int[] works) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		for (int a : works) {
			pq.add(a);
		}
		for (int i = 0; i < n; i++) {
			int top = pq.poll();
			if (top == 0) {
				break;
			}
			pq.add(--top);
		}

		long ans = 0;
		while (!pq.isEmpty()) {
			int top = pq.poll();
			ans += top * top;
		}

		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(n, works));
	}

}