package Programers;

public class Programmers_단체사진찍기 {

	static String[] data = { "N~F=0", "R~T>2" };
	static char[] cha = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
	static boolean[] visited = new boolean[8];
	static int ans = 0;

	static int solve() {
		for (int i = 0; i < 8; i++) {
			String s = "";
			s += cha[i];
			visited[i] = true;
			dfs(1, s);
			visited[i] = false;

		}
		return ans;
	}

	static void dfs(int idx, String s) {
		if (idx == 8) {
			if (!check(s)) {
				return;
			}
			ans++;
			return;
		}

		for (int i = 0; i < 8; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			dfs(idx + 1, s + cha[i]);
			visited[i] = false;
		}
	}

	static boolean check(String s) {

		for (String j : data) {
			int n1 = idx(j.charAt(0));
			int n2 = idx(j.charAt(2));
			char oper = j.charAt(3);
			int jd = j.charAt(4) - '0' + 1;
			int sd = Math.abs(s.indexOf(j.charAt(0)) - s.indexOf(j.charAt(2)));
			if (oper == '=') {
				if (jd != sd) {
					return false;
				}
			} else if (oper == '>') {
				if (jd >= sd) {
					return false;
				}
			} else {
				if (jd <= sd) {
					return false;
				}

			}
		}
		return true;
	}

	static int idx(char c) {
		if (c == 'A') {
			return 0;
		} else if (c == 'C') {
			return 1;
		} else if (c == 'F') {
			return 2;
		} else if (c == 'J') {
			return 3;
		} else if (c == 'M') {
			return 4;
		} else if (c == 'N') {
			return 5;
		} else if (c == 'R') {
			return 6;
		} else {
			return 7;
		}

	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}