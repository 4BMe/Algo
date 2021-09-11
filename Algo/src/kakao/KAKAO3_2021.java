package kakao;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class KAKAO3_2021 {

	static StringBuilder sb;
	static int[] fees = { 180, 5000, 10, 600 };
	static String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
			"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };

	static void solve() {
		List<String>[] car = new ArrayList[10001];
		for (int i = 0; i < 10000; i++) {
			car[i] = new ArrayList<String>();
		}

		for (int i = 0, c = records.length; i < c; i++) {
			StringTokenizer st = new StringTokenizer(records[i]);
			String time = st.nextToken();
			int carnum = Integer.parseInt(st.nextToken());
			car[carnum].add(time);
		}
		for (int i = 0; i < 10000; i++) {
			if (car[i].size() % 2 == 0)
				continue;
			car[i].add("23:59");
		}
		int[] useTime = new int[10001];

		for (int i = 0; i < 10000; i++) {
			if (car[i].size() == 0)
				continue;
			for (int j = 1, c = car[i].size(); j < c; j += 2) {
				StringTokenizer out = new StringTokenizer(car[i].get(j), ":");
				String outH = out.nextToken();
				String outM = out.nextToken();
				StringTokenizer in = new StringTokenizer(car[i].get(j - 1), ":");
				String inH = in.nextToken();
				String inM = in.nextToken();
				useTime[i] += (Integer.parseInt(outH) - Integer.parseInt(inH)) * 60 + Integer.parseInt(outM)
						- Integer.parseInt(inM);
			}

		}
		List<Integer> ans = new ArrayList<Integer>();
		int defM = fees[0];
		int defB = fees[1];
		int BM = fees[2];
		int BperM = fees[3];
		for (int i = 0; i < 10000; i++) {
			int m = useTime[i];
			if (m == 0)
				continue;
			if (m <= defM) {
				ans.add(defB);
				continue;
			}
			if ((m - defM) % BM != 0)
				m += BM;
			int bill = (m - defM) / BM * BperM + defB;
			ans.add(bill);
		}
		int[] res = new int[ans.size()];
		for (int i = 0, c = ans.size(); i < c; i++)
			res[i] = ans.get(i);
		for (int a : res)
			System.out.println(a);

	}

	public static void main(String[] args) throws Exception {

		solve();
	}

}
