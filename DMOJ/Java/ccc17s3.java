import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] array = new int[n];
		HashMap<Integer,Integer> map = new HashMap();
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
			map.put(array[i], map.getOrDefault(array[i], 0)+1);
		}
		int max = 0, total = 0;
		for (int i = 2; i <= 4000; i++) {
			int count = 0;
			for (int j = 1; j <= i/2; j++) {
				if (map.containsKey(j) && map.containsKey(i-j)) {
					if (j == i/2 && i % 2 == 0) {
						count += map.get(j) / 2;
					} else {
						count += Math.min(map.get(j), map.get(i-j));
					}
				}
			}
			if (count > max) {
				max = count;
				total = 1;
			} else if (count == max) {
				total++;
			}
		}
		System.out.println(max + " " + total);
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
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
