import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		for (int a = 0; a < 5; a++) {
			String str = readLine();
			String ans = "";
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '"') {
					int temp = str.indexOf('"',i+1);
					ans += str.substring(i+1,temp) + " ";
					i = temp + 1;
				} else if (str.substring(i,i+1).equals("'")) {
					int temp = str.indexOf("'",i+1);
					ans += str.substring(i+1,temp) + " ";
					i = temp + 1;
				} else if (str.charAt(i) == '/') {
					if (i < str.length()-2 && str.charAt(i+1) == '/') {
						ans += str.substring(i+2) + " ";
						break;
					} else if (i < str.length()-2 && str.charAt(i+1) == '*') {
						int temp = str.indexOf("*/");
						ans += str.substring(i+2,temp) + " ";
						i = temp+1;
					}
				}
			}
			System.out.println(ans.substring(0,ans.length()-1));
		}
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
