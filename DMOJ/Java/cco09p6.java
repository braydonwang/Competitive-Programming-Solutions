import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int c = readInt(), d = readInt(), k = readInt();
		int[] v = new int[d+1];
		double[] w = new double[d+1];
		Pair[] sorted = new Pair[d+1];
		for (int i = 1; i <= d; i++) {
			v[i] = readInt(); w[i] = readDouble();
			sorted[i] = new Pair(v[i],w[i]);
		}
		sorted[0] = new Pair(0,0);
		Arrays.sort(sorted);
		int[] array = new int[k+1];
		int sum = 0;
		double weight = 0;
		for (int i = 1; i <= k; i++) {
			array[i] = readInt();
			sum += v[array[i]];
			weight += w[array[i]];
		}
		if (sum < c) {
			System.out.println("too poor");
			return;
		}
		double[] dp = new double[sum+1];
		Arrays.fill(dp, Double.MAX_VALUE);
		dp[0] = weight;
		for (int i = 1; i <= k; i++) {
			int x = array[i];
			for (int j = sum; j >= v[x]; j--) {
				if (dp[j-v[x]] != Double.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j-v[x]] - w[x]);
				}
			}
		}
		double min = Double.MAX_VALUE;
		for (int i = c; i <= sum; i++) {
			if (dp[i] != Double.MAX_VALUE) {
				double total = 0;
				int diff = i - c;
				for (int a = d; a >= 1; a--) {
					while (true) {
						if (diff >= sorted[a].v) {
							diff -= sorted[a].v;
							total += sorted[a].w;
						} else {
							break;
						}
					}
					if (diff == 0) {
						break;
					}
				}
				min = Math.min(dp[i] + total, min);
			}
		}
		System.out.printf("%.2f\n",min);
	}
	static class Pair implements Comparable<Pair>{
		int v;
		double w;
		Pair(int v, double w){
			this.v = v;
			this.w = w;
		}
		public int compareTo(Pair p) {
			return Integer.compare(this.v, p.v);
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
