package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Programmers_징검다리건너기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
	static int k = 3;

	static int solution(int[] stones, int k) {
		int ans = Integer.MAX_VALUE;
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		int[] dp = new int[200000001];
		for (int i = 0; i < k; i++) {
			pq.add(stones[i]);
			dp[stones[i]]++;
		}
		ans = pq.peek();

		for (int i = k; i < stones.length; i++) {
			dp[stones[i - k]]--;
			dp[stones[i]]++;
			pq.add(stones[i]);
			while (dp[pq.peek()] < 1) {
				pq.poll();
			}
			ans = Math.min(ans, pq.peek());
		}
		return ans;
	}

	static int solution2(int[] stones, int k) {
		int min = 0;
		int max = Integer.MAX_VALUE;
		int ans = 0;
		while (min <= max) {
			int mid = (min + max) / 2;
			if (poss(mid, k, stones)) {
				min = mid + 1;
				ans = mid;
			} else {
				max = mid - 1;
			}
		}
		return ans;
	}

	static boolean poss(int num, int k, int[] stones) {
		int count = 0;
		for (int i = 0; i < stones.length; i++) {
			if (stones[i] < num) {
				count++;
				if (count >= k)
					return false;
			} else
				count = 0;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(stones, k));
	}

}