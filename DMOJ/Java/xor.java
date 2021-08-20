import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int i = 0; i < t; i++) {
			System.out.println(findXOR(readInt()-1) ^ findXOR(readInt()));
		}
	}
	static int findXOR(int num) {
		//finds xor of all numbers between 1 and n
		int mod = num % 4;
		if (mod == 0) {
			return num;
		} else if (mod == 1) {
			return 1;
		} else if (mod == 2) {
			return num+1;
		} else {
			return 0;
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
