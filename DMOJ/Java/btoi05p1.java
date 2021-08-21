import java.io.*;
import java.util.*;
public class CCC2{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[]args) throws IOException{
    	int r = readInt(), c = readInt();
    	int[][] pre = new int[r+1][c+1];
    	for (int i = 1; i <= r; i++) {
    		for (int j = 1; j <= c; j++) {
    			pre[i][j] += pre[i-1][j] + pre[i][j-1] + readInt() - pre[i-1][j-1];
    		}
    	}
    	int l = readInt(), w = readInt();
    	int h = readInt();
    	Query[] q = new Query[h];
    	for (int i = 0; i < h; i++) {
    		q[i] = new Query(readInt(),readInt(),readInt(),readInt(),readInt(),readInt());
    	}
    	int max = 0, y = 0, x = 0;
    	for (int i = 1; i <= r-l+1; i++) {
    		for (int j = 1; j <= c-w+1; j++) {
    			int count = 0;
    			for (int k = 0; k < h; k++) {
    				int r1 = 0, c1 = 0, r2 = 0, c2 = 0, r3 = 0, c3 = 0, r4 = 0, c4 = 0;
    				if (q[k].a == 0) {
    					r1 = i + q[k].row - 1;
    					c1 = j + q[k].col - 1;
    					r2 = r1 + q[k].len - 1;
    					c2 = c1 + q[k].wid - 1;
    					r3 = i + q[k].row - 1;
    					c3 = c1 + q[k].wid;
    					r4 = r3 + q[k].len - 1;
    					c4 = c2 + q[k].wid;
    				} else {
    					r1 = i + q[k].row - 1;
    					c1 = j + q[k].col - 1;
    					r2 = r1 + q[k].len - 1;
    					c2 = c1 + q[k].wid - 1;
    					r3 = r1 + q[k].len;
    					c3 = j + q[k].col - 1;
    					r4 = r2 + q[k].len;
    					c4 = c3 + q[k].wid - 1;
    				}
    				int sum1 = pre[r2][c2] - pre[r1-1][c2] - pre[r2][c1-1] + pre[r1-1][c1-1];
    				int sum2 = pre[r4][c4] - pre[r3-1][c4] - pre[r4][c3-1] + pre[r3-1][c3-1];
    				if (q[k].b == 0) {
    					if (sum1 < sum2) {
    						count++;
    					}
    				} else {
    					if (sum2 <= sum1) {
    						count++;
    					}
    				}
    				if (count + h - k - 1 <= max) {
    					break;
    				}
    			}
    			//System.out.println(count + " " + i + " " +j);
    			if (count > max) {
    				max = count;
    				y = i;
    				x = j;
    			}
    		}
    	}
    	System.out.println(y + " " + x);
    }
    static class Query{
    	int row, col, len, wid, a, b;
    	Query(int row, int col, int len, int wid, int a, int b){
    		this.row = row;
    		this.col = col;
    		this.len = len;
    		this.wid = wid;
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
    static String readLine () throws IOException {
  	  return br.readLine().trim();
    } 
}
