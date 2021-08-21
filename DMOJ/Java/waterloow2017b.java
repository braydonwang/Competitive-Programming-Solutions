import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		String str = next();
		Letter[] freq = new Letter[26];
		for (int i = 0; i < 26; i++) {
			freq[i] = new Letter(i,0);
		}
		for (int i = 0; i < n; i++) {
			freq[str.charAt(i)-'a'].x++;
		}
		int[] array = new int[26];
		Arrays.sort(freq);
		if (freq[0].x > k || k > n) {
			System.out.println("WRONGANSWER");
		} else {
			int sum = 0, ind = 0;
			while (sum != k) {
				if (sum + freq[ind].x <= k) {
					sum += freq[ind].x;
					array[freq[ind].ch] = freq[ind].x;
				} else {
					array[freq[ind].ch] = k-sum; 
					sum = k;
				}
				ind++;
			}
			String ans = "";
			for (int i = 0; i < n; i++) {
				if (array[str.charAt(i)-'a'] != 0) {
					ans += str.charAt(i);
					array[str.charAt(i)-'a']--;
				}
			}
			while (ans.length() != n) {
				ans += (char)(freq[0].ch + 'a');
			}
			System.out.println(ans);
		}
	}
	static class Letter implements Comparable<Letter>{
		int ch, x;
		Letter(int ch, int x){
			this.ch = ch;
			this.x = x;
		}
		public int compareTo(Letter l) {
			return this.x - l.x;
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
