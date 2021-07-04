package kaokaopay;

public class KP2 {

	static String s;

	static void init() throws Exception {

		for (int i = 0, c = s.length(); i < c; i++) {
			for (int j = i; j < c; j++) {
				check(i, i - j);
			}
		}
	}

	static boolean check(int start, int len) {
		for (int i = 0; i < len; i++) {
			if (s.charAt(start + i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {

		init();
	}

}
