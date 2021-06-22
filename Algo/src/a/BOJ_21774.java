package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

class Log {
	String date;
	int level;

	public Log(String date, int level) {
		this.date = date;
		this.level = level;
	}
}

public class BOJ_21774 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, Q;
	static SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static List<Log> log = new ArrayList<Log>();
	static HashMap<String, Integer> dp = new HashMap<>();

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		String date, level;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), "#");
			date = st.nextToken();
			level = st.nextToken();
			log.add(new Log(date, Integer.parseInt(level)));
		}
	}

	static void solve() throws Exception {
		sb = new StringBuilder();
		int cnt, level;
		String start, fin;
		for (int i = 0; i < Q; i++) {
			cnt = 0;
			st = new StringTokenizer(br.readLine(), "#");
			start = st.nextToken();
			fin = st.nextToken();
			level = Integer.parseInt(st.nextToken());
			for (int j = BSearch(start, 0), f = BSearch(fin, 1); j <= f; j++) {
				if (log.get(j).level >= level)
					cnt++;
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}

	static int BSearch(String date, int c) {
		int start = 0, mid = 0, end = log.size() - 1;
		if (dp.get(date) != null)
			return dp.get(date);

		while (start <= end) {
			mid = (start + end) / 2;
			int comp = date.compareTo(log.get(mid).date);
			if (comp > 0)
				start = mid + 1;
			else if (comp < 0)
				end = mid - 1;
			else {
				dp.put(date, mid);
				return mid;
			}
		}
		int answer;
		if (c == 0) {
			answer = date.compareTo(log.get(end).date) > 0 ? end : start;
		} else {
			if (start > log.size() - 1)
				answer = log.size() - 1;
			else
				answer = date.compareTo(log.get(start).date) < 0 ? start : end;
		}
		dp.put(date, answer);
		return answer;
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
