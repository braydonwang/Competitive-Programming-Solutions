import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		String[] array = new String[2*n];
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			String a = sc.next();
			String b = sc.next();
			if (!list.contains(a)) {
				list.add(a);
			}
			if (!list.contains(b)) {
				list.add(b);
			}
			array[i*2] = a;
			array[i*2+1] = b;
		}
		ArrayList<Integer> adj[] = new ArrayList[list.size()];
		for (int i = 0; i < list.size(); i++) {
			adj[i] = new ArrayList();
		}
		int[] in = new int[list.size()];
		for (int i = 0; i < 2*n; i+=2) {
			String c = array[i];
			String d = array[i+1];
			adj[list.indexOf(d)].add(list.indexOf(c));
			in[list.indexOf(c)]++;
		}
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < in.length; i++) {
			if (in[i] == 0) {
				q.add(i);
			}
			Collections.sort(adj[i]);
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			System.out.println(list.get(cur));
			for (int nxt: adj[cur]) {
				in[nxt]--;
				if (in[nxt] == 0) {
					q.add(nxt);
				}
			}
		}
    }
}
