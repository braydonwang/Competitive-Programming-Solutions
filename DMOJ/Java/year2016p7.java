import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][][] s;
	public static void main(String[] args) throws IOException {
		int n = readInt(), t = readInt();
		Deque<Pair> max = new LinkedList(), min = new LinkedList();
		int[] array = new int[n+1];
		int[] left = new int[n+1];
		for (int i = 1; i <= n; i++) {
			array[i] = readInt();
		}
		int q = readInt();
		int ind = 1;
		for (int i = 1; i <= n; i++) {
			while (!max.isEmpty() && max.getLast().val < array[i]) {
				max.removeLast();
			}
			while (!min.isEmpty() && min.getLast().val > array[i]) {
				min.removeLast();
			}
			max.add(new Pair(array[i],i)); min.add(new Pair(array[i],i));
			while (ind < i && max.peek().val - min.peek().val > t) {
				if (!max.isEmpty() && array[ind] == max.getFirst().val) {
					max.removeFirst();
				}
				if (!min.isEmpty() && array[ind] == min.getFirst().val) {
					min.removeFirst();
				}
				ind++;
			}
			left[i] = i-ind+1;
		}
		//System.out.println(Arrays.toString(left));
		s = new int[n+1][19][2];
		for (int i = 1; i <= n; i++) {
			s[i][0][0] = left[i];
			s[i][0][1] = i;
		}
		for (int i = 1; 1 << i <= n; i++) {
			for (int j = 1; j + (1 << i) - 1 <= n; j++) {
				if (s[j][i-1][0] >= s[j+(1 << (i-1))][i-1][0]) {
					s[j][i][0] = s[j][i-1][0];
					s[j][i][1] = s[j][i-1][1];
				} else {
					s[j][i][0] = s[j+(1 << (i-1))][i-1][0];
					s[j][i][1] = s[j+(1 << (i-1))][i-1][1];
				}
			}
		}
		//System.out.println(Arrays.toString(left));
		for (int i = 0; i < q; i++) {
			int l = readInt(), r = readInt();
			int k = l-1;
			int lo = l, hi = r;
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (mid - left[mid] + 1 < l) {
					k = mid;
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
			if (k + 1 <= r) {
				Pair temp = get(k+1,r);
				if (k-l+1 >= temp.val) {
					System.out.println(l + " " + k);
				} else {
					System.out.println(temp.ind-left[temp.ind]+1 + " " + temp.ind);
				}
			} else {
				System.out.println(l + " " + k);
			}
		}
	}
	static class Pair{
		int val, ind;
		Pair(int val, int ind){
			this.val = val;
			this.ind = ind;
		}
	}
	static Pair get(int l, int r) {
		int size = (int)(Math.log(r-l+1) / Math.log(2));
		if (s[l][size][0] >= s[r-(1 << size)+1][size][0]) {
			return new Pair(s[l][size][0],s[l][size][1]);
		} else {
			return new Pair(s[r-(1 << size)+1][size][0],s[r-(1 << size)+1][size][1]);
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
