package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_불량사용자 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
	static String[] banned_id = { "fr*d*", "abc1**" };
	static boolean[] vId;
	static boolean[] vB;
	static boolean[] vRes = new boolean[1 << 18];
	static int ans = 0;

	static int solution(String[] user_id, String[] banned_id) {
		vId = new boolean[user_id.length];
		vB = new boolean[user_id.length];
		for (int i = 0, c = user_id.length; i < c; i++) {
			for (int j = 0, w = banned_id.length; j < w; j++) {
				if (user_id[i].length() == banned_id[j].length() && isBanned(user_id[i], banned_id[j])) {
					vId[i] = true;
					vB[j] = true;
					int idx = 1 << i;
					idx = idx << banned_id.length;
					idx += 1 << j;
					dfs(1, idx);
					vId[i] = false;
					vB[j] = false;
				}
			}
		}
		return ans;
	}

	static void dfs(int cnt, int idx) {
		if (vRes[idx]) {
			return;
		}
		vRes[idx] = true;
		if (cnt == banned_id.length) {
			ans++;
			return;
		}
		for (int i = 0, c = user_id.length; i < c; i++) {
			if (vId[i]) {
				continue;
			}
			for (int j = 0, w = banned_id.length; j < w; j++) {
				if (vB[j]) {
					continue;
				}
				if (user_id[i].length() == banned_id[j].length() && isBanned(user_id[i], banned_id[j])) {
					vId[i] = true;
					vB[j] = true;
					dfs(cnt + 1, idx + ((1 << i) << banned_id.length) + (1 << j));
					vId[i] = false;
					vB[j] = false;
				}
			}
		}
	}

	static boolean isBanned(String id, String banned) {
		boolean flag = true;
		for (int k = 0, a = banned.length(); k < a; k++) {
			char ch = banned.charAt(k);
			if (ch == '*') {
				continue;
			}
			if (ch != id.charAt(k)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(user_id, banned_id));
	}

}