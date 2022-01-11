package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_기지국설치 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 16;
	static int[] stations = { 9 };
	static int w = 2;

	static int solution(int n, int[] stations, int w) {
		int end = 0;
		int ans = 0;
		for (int i = 0, c = stations.length; i < c; i++) {
			int now = stations[i];
			int right = now + w;
			int left = now - w - 1;
			int empty = left - end;
			end = Math.max(end, right);
			if (empty <= 0) {
				continue;
			}
			ans += empty / (1 + w * 2);
			if (empty % (1 + w * 2) != 0) {
				ans++;
			}
		}
		if (end < n) {
			ans += (n - end) / (1 + w * 2);
			if ((n - end) % (1 + w * 2) != 0) {
				ans++;
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(n, stations, w));
	}

}