package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Programmers_프린터 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] priorities = { 1, 1, 9, 1, 1, 1 };
	static int location = 0;

	static int solve() {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0, c = priorities.length; i < c; i++) {
			q.add(new int[] { i, priorities[i] });
			pq.add(priorities[i]);
		}
		int ans = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			if (now[1] == pq.peek()) {
				ans++;
				pq.poll();
				if (now[0] == location) {
					return ans;
				}
			} else {
				q.add(now);
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}