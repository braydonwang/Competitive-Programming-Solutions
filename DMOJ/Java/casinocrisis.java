import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), t = readInt();
		int[] array = new int[n];
		ArrayList<Integer> list = new ArrayList();
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
		}
		System.out.println(2*n);
		System.out.println("1 1");
		System.out.println("1 1");
		list.add(array[0]);
		for (int i = 1; i < n; i++) {
			int lo = 0, hi = i-1, ans = -1;
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (list.get(mid) < array[i]) {
					ans = mid;
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
			if (ans == -1) {
				ans = 1;
			} else {
				ans += 2;
			}
			if (ans > i) {
				System.out.println(ans + " " + ans);
			} else {
				System.out.println((ans) + " " + i);
			}
			System.out.println((ans) + " " + (i + 1));
			list.add(array[i]);
			Collections.sort(list);
			//System.out.println(list.get(0));
		}
    }
	static class Pair{
		int a, b;
		Pair (int a, int b){
			this.a = a;
			this.b = b;
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
