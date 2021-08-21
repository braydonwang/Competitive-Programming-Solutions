import java.io.*;
import java.util.*;
public class CCC2{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[]args) throws IOException{
    	int d = readInt();
    	int[] w = new int[d+1];
    	for (int i = 1; i <= d; i++) {
    		w[i] = readInt();
    	}
    	ArrayList<Integer> adj[] = new ArrayList[d+1];
    	for (int i = 0; i <= d; i++) {
    		adj[i] = new ArrayList();
    	}
    	int f = readInt();
    	for (int i = 0; i < f; i++) {
    		adj[readInt()].add(readInt());
    	}
    	int t = readInt();
    	int[] count = new int[d+1];
    	int[] timer = new int[d+1];
    	Arrays.fill(timer, Integer.MIN_VALUE);
    	timer[1] = 0;
    	count[1] = 1;
    	PriorityQueue<Pair> q = new PriorityQueue();
    	q.add(new Pair(1,0));
    	while (!q.isEmpty()) {
    		Pair cur = q.poll();
    		for (int nxt: adj[cur.a]) {
    			int temp = timer[cur.a] + w[nxt];
    			if (temp <= t && timer[cur.a] > timer[nxt]) {
    				timer[nxt] = temp;
    				count[nxt]++;
    				q.add(new Pair(nxt,temp));
    			}
    		}
    	}
    	//System.out.println(Arrays.toString(timer));
    	for (int i = 1; i <= d; i++) {
    		System.out.println(count[i]);
    	}
    }
    static class Pair implements Comparable<Pair>{
    	int a, b;
    	Pair(int a, int b){
    		this.a = a;
    		this.b = b;
    	}
    	public int compareTo(Pair p) {
    		return this.b - p.b;
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
