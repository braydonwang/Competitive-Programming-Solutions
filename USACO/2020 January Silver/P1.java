import java.util.*;
import java.io.*;
public class CCC2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int max = 0;
    static int n, k;
    static int[] b;
    public static void main(String[] args) throws IOException {
        n = readInt(); k = readInt();
        b = new int[n];
        for (int i = 0; i < n; i++) {
        	b[i] = readInt();
        }
        //you want all berries in baskets to be around the same number
        int lo = 1, hi = 1000, ans = 0;
        while (lo <= hi) {
        	int mid = (lo + hi) / 2;
        	max = 0;
        	if (solve(lo)) {
        		ans = Math.max(ans, max);
        		if (ans == 7) {
        			System.out.println(mid);
        		}
        		lo++;
        	} else {
        		break;
        	}
        }
        System.out.println(ans);
	}
    static boolean solve(int mid) {
    	int cnt = 0;
    	int[] c = new int[n];
    	for (int i = 0; i < n; i++) {
    		c[i] = b[i];
    	}
    	boolean good = false;
    	for (int i = 0; i < n; i++) {
    		int num = Math.min(c[i]/mid, k/2-cnt);
    		c[i] -= num*mid;
    		cnt += num;
    		if (cnt >= k/2) {
    			good = true;
    		}
    	}
    	cnt = 0;
    	for (int j = mid; j >= 1; j--) {
    		for (int i = 0; i < n; i++) {
    			int num = Math.min(c[i]/j, k/2-cnt);	
    			c[i] -= num*j;
    			max += num*j;
    			cnt += num;
    			if (cnt == k/2) {
    				return good;
    			}
    		}
    	}
    	return good;
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
