package a;

public class TOSS_4 {

	static void init() throws Exception {
		String input = "1 2SHOWSHOWNEXTSHOWNEXTSHOWNEXTSHOWEXIT";
		String sub = input.substring(3);
		for (int i = 0, c = sub.length(); i < c; i += 4) {
			String comm = sub.substring(i, i+4);
			if(sub.equals("SHOW")) {
				
			}
		}
		String answer = "";
	}

	public static void main(String[] args) throws Exception {

		init();
	}

}
