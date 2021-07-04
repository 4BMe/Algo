package kaokaopay;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class KP3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String ss = "";
	static String tt = "";
	static String out = "";
	static long thash = 0;
	static long shash = 0;
	static String[] f = { "a", "b", "c" };

	static void read() throws Exception {
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j < 3; j++) {
				byte[] b = new byte[1024000];
				byte[] c = new byte[1024000];
				FileInputStream input = new FileInputStream(
						"C:\\Users\\green\\Desktop\\contest5_testdata\\eksplozija\\eksplozija.in." + i + f[j]);
				input.read(b);
				String[] sp = new String(b).split("\n");
				System.out.println(i + f[j]);
				System.out.println(sp.length);
				ss = sp[0].trim();
				tt = sp[1].trim();
				init();
				FileInputStream output = new FileInputStream(
						"C:\\Users\\green\\Desktop\\contest5_testdata\\eksplozija\\eksplozija.out." + i + f[j]);
				output.read(c);
				String out = new String(c).trim();
				if (!ss.equals(out)) {
					System.out.println("ss " + sp[0].trim());
					System.out.println("tt " + sp[1].trim());
					System.out.println("결과 " + ss);
					System.out.println("정답 " + out);
					System.out.println("실패");
				}
				input.close();
				output.close();
			}
		}
	}

	static String init() throws Exception {
		thash = shash = 0;
		for (int i = 0, c = tt.length(); i < c; i++) {
			thash += tt.charAt(i) * (1 << (c - 1 - i));
		}
		while (find()) {
			if (ss.length() < tt.length())
				break;
		}
		return ss.length() != 0 ? ss : "FRULA";
	}

	static boolean find() {
		if (ss.length() < tt.length())
			return false;
		shash = 0;
		for (int i = 0, c = tt.length(); i < c; i++) {
			shash += ss.charAt(i) * (1 << (c - 1 - i));
		}
		for (int i = 0, c = ss.length() - tt.length(); i <= c; i++) {
			if (i > 0) {
				shash -= ss.charAt(i - 1) * (1 << (tt.length() - 1));
				shash *= 2;
				shash += ss.charAt(i + tt.length() - 1);
			}
			if (shash == thash) {
				if (comp(i))
					return true;
			}
		}

		return false;
	}

	static boolean comp(int start) {

		int sfoot, same;
		sfoot = start;
		same = 0;
		while (true) {
			if (ss.charAt(sfoot + same) == tt.charAt(same)) {
				same++;
				if (same == tt.length()) {
					String be = ss.substring(0, sfoot);
					String af = ss.substring(sfoot + same, ss.length());
					ss = be + af;
					return true;
				}
			} else {
				return false;
			}
		}

	}

	public static void main(String[] args) throws Exception {

		init();
//		read();
	}

}
