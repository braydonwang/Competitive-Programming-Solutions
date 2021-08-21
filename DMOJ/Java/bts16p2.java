import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int t = -1, f = -1;
		for (int i = 0; i < n; i++) {
			int num = readInt();
			if (num == 1) {
				String str = next();
				if (str.equals("true")) {
					if (t == -1) {
						t = f+1;
						System.out.println("true");
					} else {
						System.out.println("false");
					}
				} else {
					if (f == -1) {
						f = t+1;
						System.out.println("true");
					} else {
						System.out.println("false");
					}
				}
			} else if (num == 2) {
				String str = next();
				if (str.equals("true")) {
					if (t != -1) {
						if (f > t) {
							f--;
						}
						t = -1;
						System.out.println("true");
					} else {
						System.out.println("false");
					}
				} else {
					if (f != -1) {
						if (t > f) {
							t--;
						}
						f = -1;
						System.out.println("true");
					} else {
						System.out.println("false");
					}
				}
			} else if (num == 3) {
				String str = next();
				if (str.equals("true")) {
					System.out.println(t);
				} else {
					System.out.println(f);
				}
			} else {
				if (t != -1 && f != -1) {
					System.out.println("false true");
				} else if (t != -1) {
					System.out.println("true");
				} else if (f != -1){
					System.out.println("false");
				}
			}
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
