import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int m = readInt(), n = readInt(), c = readInt(), C = readInt();
		HashMap<Integer,Integer> map1 = new HashMap();
		HashMap<Integer,Integer> map2 = new HashMap();
		int[] row = new int[m], col = new int[n];
		for (int i = 0; i < m; i++) {
			row[i] = readInt(); map1.put(row[i],map1.getOrDefault(row[i], 0)+1);
		}
		for (int i = 0; i < n; i++) {
			col[i] = readInt(); map2.put(col[i],map2.getOrDefault(col[i], 0)+1);
		}
		Arrays.sort(row); Arrays.sort(col);
		if (row[m-1] != col[n-1]) {
			System.out.println("Impossible");
			return;
		}
		long psa = 0;
		int ind = 0;
		long max = 0, min = 0;
		for (int i = 0; i < n; i++) {
			while(ind < m && row[ind] <= col[i]) {
				psa += row[ind]; ind++;
			}
			max += psa + (m-ind)*col[i];
		}
		for (int x: map1.keySet()) {
			if (map2.containsKey(x)) {
				min += Math.max(map1.get(x),map2.get(x))*x;
			} else {
				min += map1.get(x)*x;
			}
		}
		for (int x: map2.keySet()) {
			if (!map1.containsKey(x)) {
				min += map2.get(x)*x;
			}
		}
		System.out.println("Minimum: " + (min*c) + ", maximum: " + (max*C));
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
