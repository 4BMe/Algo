package Yo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class Yo2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String S = "715K 2009-09-23 system.zip~\n" + "179K 2013-08-14 to-do-list.xml~\n"
			+ "645K 2013-06-19 blockbuster.mpeg~\n" + "536 2010-12-12 notes.html\n"
			+ "688M 1990-02-11 delete-this.zip~\n" + "23K 1987-05-24 setup.png~\n" + "616M 1965-06-06 important.html\n"
			+ "14M 1992-05-31 crucial-module.java~\n" + "192K 1990-01-31 very-long-filename.dll~";

	static void init() throws Exception {
	}

	static void solve() {
		st = new StringTokenizer(S, "\n");
		StringTokenizer cur;
		String size, date, name;
		int answer = Integer.MAX_VALUE;
		for (int i = 0, c = st.countTokens(); i < c; i++) {
			cur = new StringTokenizer(st.nextToken());
			size = cur.nextToken();
			date = cur.nextToken();
			name = cur.nextToken();
			if (checkSize(size) && checkDate(date) && checkName(name)) {
				System.out.println(name);
				answer = Math.min(answer, name.indexOf("."));
			}
		}
		System.out.println(answer);
	}

	static boolean checkSize(String size) {
		char ch = size.charAt(size.length() - 1);
		if (ch == 'G')
			return false;
		else if (ch == 'M') {
			if (Integer.parseInt(size.substring(0, size.length() - 1)) >= 14)
				return false;
		}
		return true;
	}

	static boolean checkDate(String date) {
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Date mdate = null;
		try {
			mdate = dt.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (mdate.compareTo(new Date(90, 01, 31)) <= 0)
			return false;
		return true;
	}

	static boolean checkName(String name) {
		if (name.charAt(name.length() - 1) != '~')
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
