import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] value = {1,5,10,50,100,500,1000};
	static String[] ch = {"I","V", "X","L","C","D","M"};
	public static void main(String[] args) throws IOException {
		String str = next();
		int total = 0;
		String[] array = str.split("");
		for (int i = str.length() - 2; i >= 0; i-=2) {
			int num = Integer.parseInt(array[i]);
			String letter = array[i+1];
			if (i != str.length()-2) {
				if (getValue(letter) < getValue(array[i+3])){
					total -= getValue(letter) * num;
				} else {
					total += getValue(letter) * num;
				}
			} else {
				total += getValue(letter) * num;
			}
		}
		System.out.println(total);
	}
	static int getValue(String str) {
		for (int i = 0; i < value.length; i++) {
			if (ch[i].equals(str)) {
				return value[i];
			}
		}
		return 0;
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
