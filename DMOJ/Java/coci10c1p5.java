import java.util.*;
import java.io.*;
public class CCC2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
        	p[i] = readInt();
        }
        for (int i = 0; i < n; i++) {
        	p[i] -= readInt();
        }
        int ans = 0;
        while (true) {
        	//System.out.println(Arrays.toString(p));
        	boolean done = true;
        	int max = 0, l = 0, r = 0, count = 0, par = 0;
        	for (int i = 0; i < n; i++) {
        		if (p[i] < 0) {
        			done = false;
        			if (par == -1) {
        				count++;
        				if (count > max) {
        					r = i; l = i - count + 1;
        					max = count;
        				}
        			} else {
        				count = 1;
        				par = -1;
        				if (count > max) {
        					r = i; l = i - count + 1;
        					max = count;
        				}
        			}
        		} else if (p[i] > 0) {
        			done = false;
        			if (par == 1) {
        				count++;
        				if (count > max) {
        					r = i; l = i - count + 1;
        					max = count;
        				}
        			} else {
        				par = 1;
        				count = 1;
        				if (count > max) {
        					r = i; l = i - count + 1;
        					max = count;
        				}
        			}
        		} else {
        			count = 1;
        			par = 0;
        		}
        	}
        	if (done) {
        		break;
        	}
        	int min = Integer.MAX_VALUE;
        	for (int i = l; i <= r; i++) {
        		min = Math.min(min, Math.abs(p[i]));
        	}
        	for (int i = l; i <= r; i++) {
        		if (p[i] < 0) {
        			p[i] += min;
        		} else {
        			p[i] -= min;
        		}
        	}
        	ans += min;
        }
        System.out.println(ans);
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
