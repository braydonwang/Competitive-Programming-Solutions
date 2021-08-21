import java.io.*;
import java.util.*;
public class CCC2{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long[] bit;
    static int n;
    public static void main(String[]args) throws IOException{
    	n = readInt();
    	bit = new long[n+1];
    	P[] array = new P[n];
    	for (int i = 0; i < n; i++) {
    		array[i] = new P(readInt(),i+1);
    	}
    	Arrays.sort(array);
    	int q = readInt();
    	Pair[] temp = new Pair[q];
    	long[] ans = new long[q];
    	for (int i = 0; i < q; i++) {
    		temp[i] = new Pair(readInt()+1,readInt()+1,readInt(),i);
    	}
    	Arrays.sort(temp);
    	int idx = 0;
    	for (int i = 0; i < n;) {
    		int x = array[i].val;
    		if (temp[idx].q > x) {
    			//System.out.println("A");
    			ans[temp[idx].ind] = query(temp[idx].b) - query(temp[idx].a-1);
    			idx++;
    			if (idx == q) {
    				break;
    			}
    		} else {
    			//System.out.println("B");
    			update(array[i].ind,array[i].val);
    			i++;
    		}
    	}
    	for (; idx < q; idx++) {
    		ans[temp[idx].ind] = query(temp[idx].b) - query(temp[idx].a-1);
    	}
    	for (long c: ans) {
    		System.out.println(c);
    	}
    }
    static class P implements Comparable<P>{
    	int val, ind;
    	P(int val, int ind){
    		this.val = val;
    		this.ind = ind;
    	}
    	public int compareTo(P p) {
    		return p.val - this.val;
    	}
    }
    static class Pair implements Comparable<Pair>{
    	int a, b, q, ind;
    	Pair(int a, int b, int q, int ind){
    		this.a = a;
    		this.b = b;
    		this.q = q;
    		this.ind = ind;
    	}
    	public int compareTo(Pair p) {
    		return p.q - this.q;
    	}
    }
    static void update(int x, int val) {
    	for (int i = x; i <= n; i += i & -i) {
    		bit[i] += val;
    	}
    }
    static long query(int x) {
    	long sum = 0;
    	for (int i = x; i > 0; i -= i & -i) {
    		sum += bit[i];
    	}
    	return sum;
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
