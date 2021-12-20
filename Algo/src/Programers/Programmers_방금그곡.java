package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.StringTokenizer;

public class Programmers_방금그곡 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String m = "ABC";
	static String[] musicinfos = { "12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF" };

	static String solve(String m, String[] musicinfos) {
		m = m.replaceAll("C#", "X");
		m = m.replaceAll("D#", "Y");
		m = m.replaceAll("F#", "Z");
		m = m.replaceAll("G#", "W");
		m = m.replaceAll("A#", "V");
		SimpleDateFormat f = new SimpleDateFormat("HH:mm");
		Date time = null;
		Date time2 = null;
		Arrays.sort(musicinfos, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				StringTokenizer st1 = new StringTokenizer(o1, ",");
				StringTokenizer st2 = new StringTokenizer(o2, ",");
				Date time = null;
				Date time2 = null;
				try {
					time = f.parse(st1.nextToken());
					time2 = f.parse(st1.nextToken());
				} catch (Exception e) {
				}
				int diff1 = (int) ((time2.getTime() - time.getTime()) / (60 * 1000));

				Date time21 = null;
				Date time22 = null;
				try {
					time21 = f.parse(st2.nextToken());
					time22 = f.parse(st2.nextToken());
				} catch (Exception e) {
				}
				int diff2 = (int) ((time22.getTime() - time21.getTime()) / (60 * 1000));
				if (diff2 == diff1) {
					return (int) ((time.getTime() - time21.getTime()) / (60 * 1000));
				}
				return diff2 - diff1;
			}
		});

		for (String s : musicinfos) {
			StringTokenizer st = new StringTokenizer(s, ",");

			try {
				time = f.parse(st.nextToken());
				time2 = f.parse(st.nextToken());
			} catch (Exception e) {
			}
			int diff = (int) ((time2.getTime() - time.getTime()) / (60 * 1000));
			String name = st.nextToken();
			String umm = st.nextToken();
			umm = umm.replaceAll("C#", "X");
			umm = umm.replaceAll("C#", "X");
			umm = umm.replaceAll("D#", "Y");
			umm = umm.replaceAll("F#", "Z");
			umm = umm.replaceAll("G#", "W");
			umm = umm.replaceAll("A#", "V");
			if (diff > umm.length()) {
				while (umm.length() <= diff) {
					umm += umm;
				}
			} else {
				umm = umm.substring(0, diff);
			}
			System.out.println(umm);
			if (umm.contains(m) || m.contains(umm)) {
				return name;
			}
		}
		return "(None)";
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(m, musicinfos));
	}

}