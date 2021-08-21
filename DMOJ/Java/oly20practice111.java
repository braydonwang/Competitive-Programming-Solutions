import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		for (int a = 0; a < 5; a++) {
			String str = readLine().replaceAll(" ","");
			Stack<Integer> st = new Stack<Integer>();
			if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
						st.add(str.charAt(i)-'0');
					} else {
						int y = st.pop(), x = st.pop();
						int temp = 0;
						if (str.charAt(i) == '+') {
							temp = x + y;
						} else if (str.charAt(i) == '-') {
							temp = x - y;
						} else if (str.charAt(i) == '*') {
							temp = x * y;
						} else if (str.charAt(i) == '/') {
							temp = x / y;
						} else {
							temp = x % y;
						}
						st.add(temp);
					}
				} 	
			} else {
				for (int i = str.length()-1; i >= 0; i--) {
					if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
						st.add(str.charAt(i)-'0');
					} else {
						int x = st.pop(), y = st.pop();
						int temp = 0;
						if (str.charAt(i) == '+') {
							temp = x + y;
						} else if (str.charAt(i) == '-') {
							temp = x - y;
						} else if (str.charAt(i) == '*') {
							temp = x * y;
						} else if (str.charAt(i) == '/') {
							temp = x / y;
						} else {
							temp = x % y;
						}
						st.add(temp);
					}
				} 	
			}
			System.out.println(st.pop());
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
