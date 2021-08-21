import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String str = next();
		int n = str.length();
		String ans = str;
		for (int i = 0; i < n-2; i++) {
			for (int j = i+1; j < n-1; j++) {
				String temp = rev(str.substring(0,i+1)) + rev(str.substring(i+1,j+1)) + rev(str.substring(j+1));
				//System.out.println(temp);
				if (temp.compareTo(ans) < 0) {
					ans = temp;
				}
			}
		}
		System.out.println(ans);
	}
	static String rev(String s) {
		String ret = "";
		for (int i = s.length()-1; i >= 0; i--) {
			ret += s.charAt(i);
		}
		return ret;
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
