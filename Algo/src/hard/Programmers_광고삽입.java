package hard;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_광고삽입 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String play_time = "02:03:55";
	static String adv_time = "00:14:15";
	static String[] logs = { "01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29",
			"01:37:44-02:02:30" };

	static String solution(String play_time, String adv_time, String[] logs) {
		int playTime = sToInt(play_time);
		int advTime = sToInt(adv_time);
		long[] dp = new long[playTime + 1];

		for (String log : logs) {
			String[] times = log.split("-");
			int start = sToInt(times[0]);
			int end = sToInt(times[1]);
			dp[start]++;
			dp[end]--;
		}

		for (int i = 1; i <= playTime; i++) {
			dp[i] += dp[i - 1];
		}
		for (int i = 1; i <= playTime; i++) {
			dp[i] += dp[i - 1];
		}

		long max = dp[advTime - 1];
		int maxTime = 0;

		for (int i = advTime; i <= playTime; i++) {
			if (max < dp[i] - dp[i - advTime]) {
				max = dp[i] - dp[i - advTime];
				maxTime = i - advTime + 1;
			}
		}

		return iToString(maxTime);
	}

	static int sToInt(String s) {
		int res = 0;
		res += Integer.parseInt(s.substring(0, 2)) * 3600;
		res += Integer.parseInt(s.substring(3, 5)) * 60;
		res += Integer.parseInt(s.substring(6, 8));
		return res;
	}

	static String iToString(int i) {
		int h = i / 3600;
		i %= 3600;
		int m = i / 60;
		int s = i % 60;
		StringBuilder sb = new StringBuilder();
		sb.append((h / 10 == 0 ? "0" + String.valueOf(h) : String.valueOf(h)) + ":");
		sb.append((m / 10 == 0 ? "0" + String.valueOf(m) : String.valueOf(m)) + ":");
		sb.append(s / 10 == 0 ? "0" + String.valueOf(s) : String.valueOf(s));

		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(play_time, adv_time, logs));
	}

}