package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_수식최대화 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String expression = "1*1*1*1*1";
	static boolean[] visited;
	static String[] oper = { "+", "-", "*" };

	static long ans = 0;

	static long solve() {

		visited = new boolean[3];
		for (int i = 0; i < 3; i++) {
			visited[i] = true;
			dfs(1, oper[i]);
			visited[i] = false;
		}
		return ans;
	}

	static void dfs(int cnt, String s) {
		if (cnt == 3) {
			List<Long> num = new ArrayList<Long>();
			List<String> op = new ArrayList<String>();
			st = new StringTokenizer(expression, "[0123456789]");
			for (int i = 0, c = st.countTokens(); i < c; i++) {
				op.add(st.nextToken());
			}

			st = new StringTokenizer(expression, "*-+");
			for (int i = 0, c = st.countTokens(); i < c; i++) {
				num.add(Long.parseLong(st.nextToken()));
			}

			for (int i = 0; i < 3; i++) {
				char pop = s.charAt(i);
				for (int j = 0; j < op.size(); j++) {
					char nop = op.get(j).charAt(0);
					if (nop == pop) {
						Long res;
						if (nop == '+') {
							res = num.get(j) + num.get(j + 1);
						} else if (nop == '-') {
							res = num.get(j) - num.get(j + 1);
						} else {
							res = num.get(j) * num.get(j + 1);
						}
						op.remove(j);
						num.remove(j);
						num.remove(j);
						num.add(j, res);
						j--;
					}
				}
			}
			ans = Math.max(ans, Math.abs(num.get(0)));
		}
		for (int i = 0; i < 3; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			dfs(cnt + 1, s + oper[i]);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}