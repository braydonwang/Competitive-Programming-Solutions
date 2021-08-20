import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int mod = (int)1e9+7;
	public static void main(String[] args) throws IOException {
		int n = readInt(), f = readInt();
		long s = readLong();
		int[] a = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = readInt();
		}
		int[] freq = new int[(int)1e5+5];
		int l = 1, r = 1;
		long go = 0, gr = 0, gogr = 0;
		while (true) {
			if (r > n) {
				break;
			}
			freq[a[r]]++;
			if (freq[a[r]] > f) {
				while (l <= r) {
					freq[a[l]]--;
					if (a[l] == a[r]) {
						l++;
						break;
					}
					l++;
				}
				if (l <= r) {
					go += r - l + 1;
				}
			} else {
				if (l <= r) {
					go += r - l + 1;
				}
			}
			if (l > r) {
				r = l;
			} else {
				r++;
			}
		}
		long sum = 0;
		l = 1; r = 1;
		while (true) {
			if (r > n) {
				break;
			}
			sum += a[r];
			if (sum > s) {
				while (l <= r) {
					sum -= a[l];
					if (sum <= s) {
						l++;
						break;
					}
					l++;
				}
				if (l <= r) {
					gr += r - l + 1;
				}
			} else {
				if (l <= r) {
					gr += r - l + 1;
				}
			}
			if (l > r) {
				r = l;
			} else {
				r++;
			}
		}
		sum = 0;
		freq = new int[(int)1e5+5];
		l = 1; r = 1;
		while (true) {
			if (r > n) {
				break;
			}
			sum += a[r]; freq[a[r]]++;
			if (sum > s && freq[a[r]] > f) {
				while (l <= r) {
					sum -= a[l]; freq[a[l]]--;
					if (sum <= s && a[l] == a[r]) {
						l++;
						break;
					}
					l++;
				}
				if (l <= r) {
					gogr += r - l + 1;
				}
			} else if (sum > s) {
				while (l <= r) {
					sum -= a[l]; freq[a[l]]--;
					if (sum <= s) {
						l++;
						break;
					}
					l++;
				}
				if (l <= r) {
					gogr += r - l + 1;
				}
			} else if (freq[a[r]] > f){
				while (l <= r) {
					freq[a[l]]--; sum -= a[l];
					if (a[l] == a[r]) {
						l++;
						break;
					}
					l++;
				}
				if (l <= r) {
					gogr += r - l + 1;
				}
			} else {
				if (l <= r) {
					gogr += r - l + 1;
				}
			}
			r++;
		}
		System.out.println(((((go % mod) * (gr % mod)) % mod) * (gogr % mod)) % mod);
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
