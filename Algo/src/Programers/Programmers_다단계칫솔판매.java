package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Programmers_다단계칫솔판매 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String[] enroll = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
	static String[] referral = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
	static String[] seller = { "young", "john", "tod", "emily", "mary" };
	static int[] amount = { 12, 4, 2, 5, 10 };

	static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		Map<String, p> map = new LinkedHashMap<String, p>();

		for (int i = 0, c = enroll.length; i < c; i++) {
			String me = enroll[i];
			if (!map.containsKey(me)) {
				map.put(me, new p(me));
			}
			String parent = referral[i];
			if (parent.equals("-")) {
				parent = "root";
			}
			if (!map.containsKey(parent)) {
				map.put(parent, new p(parent));
			}
			p child = map.get(me);
			p p = map.get(parent);
			child.parent = p;
		}
		for (int i = 0, c = seller.length; i < c; i++) {
			p sellP = map.get(seller[i]);
			int am = amount[i] * 100;
			while (sellP.parent != null) {
				int ten = (int) (am * 0.1);
				if (ten < 1) {
					sellP.sum += am;
					break;
				}
				sellP.sum += am - ten;
				am = ten;
				sellP = sellP.parent;
			}
		}
		map.remove("root");
		return map.entrySet().stream().mapToInt(e -> e.getValue().sum).toArray();
	}

	public static void main(String[] args) throws Exception {
		for (int a : solution(enroll, referral, seller, amount)) {
			System.out.print(a + " ");
		}
	}

	static class p {
		String name;
		int sum;
		p parent;

		public p(String name) {
			this.name = name;
			this.parent = null;
			this.sum = 0;
		}

	}
}