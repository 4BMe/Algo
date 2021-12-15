package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_구명보트 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] people = { 70, 50, 80, 50 };
	static int limit = 100;
	static List<Integer> p;

	static int solve(int[] people, int limit) {
		int ans = 0;
		Arrays.sort(people);
		Deque<Integer> q = new LinkedList<Integer>();
		for (int a : people) {
			q.add(a);
		}
		while (!q.isEmpty()) {
			int last = q.pollLast();
			if (!q.isEmpty() && last + q.peekFirst() <= limit) {
				q.pollFirst();
			}
			ans++;
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {

		System.out.println(solve(people, limit));
	}

}