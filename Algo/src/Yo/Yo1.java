package Yo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Yo1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String s = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
	static String C = "Example";
	static HashMap<String, Integer> ch = new HashMap<>();

	static void init() throws Exception {
	}

	static void solve() {

		st = new StringTokenizer(s, ";");

		sb = new StringBuilder();
		HashMap<String, Integer> ch = new HashMap<>();

		StringTokenizer temp;
		String cur, first, middle, last;

		for (int i = 0, c = st.countTokens(); i < c; i++) {
			cur = st.nextToken();
			temp = new StringTokenizer(cur);
			if (temp.countTokens() == 3) {
				first = temp.nextToken();
				middle = temp.nextToken();
				last = temp.nextToken();
				sb.append(first + " " + middle + " " + last + " <");
			} else {
				first = temp.nextToken();
				last = temp.nextToken();
				sb.append(first + " " + last + " <");
			}
			last = Last(last);
			int cnt = same(first + last);

			if (cnt == 1)
				sb.append(first.toLowerCase() + "." + last.toLowerCase() + "@" + C.toLowerCase() + ".com");
			else
				sb.append(first.toLowerCase() + "." + last.toLowerCase() + cnt + "@" + C.toLowerCase() + ".com");
			if (i < c - 1)
				sb.append(">; ");
			else
				sb.append(">");
		}
		System.out.println(sb);
	}

	static String Last(String last) {
		String result = "";
		for (int i = 0, c = last.length(); i < c; i++) {
			if (last.charAt(i) == '-')
				continue;
			result += last.charAt(i);
		}

		return result.length() <= 8 ? result : result.substring(0, 8);
	}

	static int same(String email) {
		if (ch.get(email) == null) {
			ch.put(email, 1);
			return 1;
		} else {
			int cnt = ch.get(email) + 1;
			ch.put(email, cnt);
			return cnt;
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
