package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Programers_완주하지못한선수 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String[] participant;
	static String[] completion;

	static void init() throws Exception {
	}

	static String solve() {
		Map<String, Integer> comple = new HashMap<String, Integer>();

		for (int i = 0, c = completion.length; i < c; i++) {
			comple.put(completion[i], comple.getOrDefault(completion[i], 0) + 1);
		}
		String answer = "";

		for (int i = 0, c = participant.length; i < c; i++) {
			int cnt = comple.getOrDefault(participant[i], 0);
			if (cnt == 0) {
				answer = participant[i];
				break;
			}
			comple.put(participant[i], cnt - 1);
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		long beforeTime = System.currentTimeMillis();
		init();
		solve();
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime) / 1000;
		System.out.println("시간차이(m) : " + secDiffTime);
	}

}