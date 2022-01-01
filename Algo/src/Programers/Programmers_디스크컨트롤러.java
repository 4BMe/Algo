package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Programmers_디스크컨트롤러 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] jobs = { { 24, 10 }, { 28, 39 }, { 43, 20 }, { 37, 5 }, { 47, 22 }, { 20, 47 }, { 15, 34 },
			{ 15, 2 }, { 35, 43 }, { 26, 1 } };
	static int[][] jobs2 = { { 0, 5 }, { 2, 10 }, { 10000, 2 } };

	static int solution(int[][] jobs) {
		PriorityQueue<int[]> rq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		for (int[] a : jobs) {
			rq.add(a);
		}

		PriorityQueue<int[]> wq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		int ans = 0;
		int time = 0;
		int len = jobs.length;

		while (!rq.isEmpty()) {
			while (!rq.isEmpty() && time >= rq.peek()[0]) {
				wq.add(rq.poll());
			}
			if (wq.isEmpty()) {
				time = rq.peek()[0];
				continue;
			}
			if (rq.isEmpty()) {
				while (!wq.isEmpty()) {
					int[] now = wq.poll();
					time += now[1];
					ans += time - now[0];
				}
			} else {
				while (!wq.isEmpty() && time < rq.peek()[0]) {
					int[] now = wq.poll();
					time += now[1];
					ans += time - now[0];
				}
			}
		}

		return ans / (len);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(jobs2));
	}

}