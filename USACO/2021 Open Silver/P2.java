import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int z = 0; z < t; z++) {
			int n = readInt();
			int[] x = new int[7];
			Set<Integer> cand = new TreeSet();
			for (int i = 0; i < n; i++) {
				x[i] = readInt(); cand.add(x[i]);
				for (int j = 0; j < i; j++) {
					cand.add(Math.abs(x[i]-x[j]));
				}
			}
			int i = 0, j = 0, k = 0;
			int count = 0;
			for (int a: cand) {
				j = 0;
				for (int b: cand) {
					if (j >= i) {
						k = 0;
						for (int c: cand) {
							if (k >= j) {
								ArrayList<Integer> list = new ArrayList<>(Arrays.asList(a,b,c,a+b,b+c,a+c,a+b+c));
								boolean flag = true;
								for (int l = 0; l < n; l++) {
									if (list.contains(x[l])) {
										continue;
									}
									flag = false;
									break;
								}
								if (flag) {
									count++;
								}
							}
							k++;
						}
					}
					j++;
				}
				i++;
			}
			System.out.println(count);
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
