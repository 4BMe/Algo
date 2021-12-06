package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_조이스틱 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String name = "ZAAAAAAAZAAAAAAAAAAA";

	static int solve() {
		int len = name.length();
		int ans = 0;
		boolean[] diff = new boolean[len];
		int cnt = 0;
		for (int i = 0; i < len; i++) {
			char c = name.charAt(i);
			if (c != 'A') {
				diff[i] = true;
				cnt++;
				ans += Math.min(c - 'A', 'Z' - c + 1);
			}
		}
		if (diff[0] == true) {
			cnt--;
			diff[0] = false;
		}
		int idx = 0;
		while (cnt > 0) {
			for (int i = 1; i < len; i++) {
				int front = (idx + i) % len;
				int back = (idx - i) % len;
				back = back < 0 ? len + back : back;
				if (diff[front]) {
					System.out.println(idx + " + " + i);
					diff[front] = false;
					cnt--;
					idx = front;
					ans += i;
					break;
				} else if (diff[back]) {
					System.out.println(idx + " - " + i);
					diff[back] = false;
					cnt--;
					idx = back;
					ans += i;
					break;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}