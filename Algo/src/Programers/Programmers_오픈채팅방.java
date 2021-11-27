package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_오픈채팅방 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
			"Change uid4567 Ryan" };

	static String[] solution() {
		int len = record.length;
		List<String> res = new ArrayList<String>();
		HashMap<String, String> user = new HashMap<String, String>();

		for (int i = 0; i < len; i++) {
			st = new StringTokenizer(record[i]);
			String action = st.nextToken();
			String id = st.nextToken();
			if (action.equals("Leave")) {
				res.add(id + " 님이 " + "나갔습니다.");
			} else {
				String name = st.nextToken();
				if (action.equals("Enter")) {
					user.put(id, name);
					res.add(id + " 님이 " + "들어왔습니다.");
				} else {
					user.put(id, name);
				}
			}
		}
		String[] ans = new String[res.size()];
		for (int i = 0, c = res.size(); i < c; i++) {
			st = new StringTokenizer(res.get(i));
			String id = st.nextToken();
			id = user.get(id);
			ans[i] = id + st.nextToken() + " " + st.nextToken();

		}

		return ans;
	}

	public static void main(String[] args) throws Exception {
		String[] res = solution();
		for (String string : res) {
			System.out.println(string);
		}
	}

}