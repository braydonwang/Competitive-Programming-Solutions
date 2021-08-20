import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] card;
	static int ans;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		for (int a = 0; a < n; a++) {
			card = new int[4];
			ans = 0;
			for (int i = 0; i < 4; i++) {
				card[i] = readInt();
			}
			heapPermutation(4,4);
			System.out.println(ans);
		}
	}
	static void heapPermutation(int size, int n){
        if (size == 1) {
        	fun(card[0],card[1],1);
        }
        for (int i = 0; i < size; i++) {
            heapPermutation(size - 1, n);
            if (size % 2 == 1) {
                int temp = card[0];
                card[0] = card[size - 1];
                card[size - 1] = temp;
            }
            else {
                int temp = card[i];
                card[i] = card[size - 1];
                card[size - 1] = temp;
            }
        }
    }
	static void check(int val) {
		if (val <= 24 && val >= 0) {
			ans = Math.max(ans, val);
		}
	}
	static void fun(int cur, int nxt, int idx) {
		if (idx == 3) {
			check(cur + nxt); check(cur - nxt); check(cur * nxt);
			if (nxt != 0 && cur % nxt == 0) {
				check(cur/nxt);
			}
			return;
		}
		fun(cur+nxt,card[idx+1],idx+1);
		fun(cur-nxt,card[idx+1],idx+1);
		fun(cur*nxt,card[idx+1],idx+1);
		if (nxt != 0 && cur % nxt == 0) {
			fun(cur/nxt,card[idx+1],idx+1);
		}
		fun(cur,nxt+card[idx+1],idx+1);
		fun(cur,nxt-card[idx+1],idx+1);
		fun(cur,nxt*card[idx+1],idx+1);
		if (card[idx+1] != 0 && nxt % card[idx+1] == 0) {
			fun(cur,nxt/card[idx+1],idx+1);
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
