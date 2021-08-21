import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String[] digit = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
	static String[] ten = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
	public static void main(String[] args) throws IOException {
		String r = next(), ans = r;
		int num = romanToInt(r);
		for (int i = 1; i < num; i++) {
			String r2 = intToRoman(i);
			if (check(r,r2)) {
				ans = r2;
				break;
			}
		}
		System.out.println(ans);
	}
	static String intToRoman(int num) {
		return ten[num/10] + digit[num%10];
	}
	static int romanToInt(String str) {
		int ret = 0;
		for (int i = 9; i >= 1; i--) {
			if (ten[i].length() <= str.length() && str.substring(0,ten[i].length()).equals(ten[i])) {
				ret = i*10; str = str.substring(ten[i].length());
			}
		}
		for (int i = 9; i >= 1; i--) {
			if (str.equals(digit[i])) {
				ret += i;
			}
		}
		return ret;
	}
	static boolean check(String r, String r2) {
		char[] array = r.toCharArray();
		char[] array2 = r2.toCharArray();
		Arrays.sort(array); Arrays.sort(array2);
		if (Arrays.equals(array, array2)) {
			return true;
		}
		return false;
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
