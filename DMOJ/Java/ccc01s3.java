import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Integer> adj[] = new ArrayList[26];
		ArrayList<String> roads = new ArrayList<String>();
		for (int i = 0; i < 26; i++) {
			adj[i] = new ArrayList();
		}
		int count = 0;
		while (true) {
			String str = sc.next();
			if (str.equals("**")) {
				break;
			}
			count++;
			String x = str.substring(0,1);
			String y = str.substring(1);
			if (!list.contains(x)) {
				list.add(x);
			}
			if (!list.contains(y)) {
				list.add(y);
			}
			roads.add(str);
			adj[list.indexOf(x)].add(list.indexOf(y));
			adj[list.indexOf(y)].add(list.indexOf(x));
		}
		int total = 0;
		for (int i = 0; i < count; i++) {
			String a = roads.get(i).substring(0,1);
			String b = roads.get(i).substring(1);
			adj[list.indexOf(a)].remove(adj[list.indexOf(a)].indexOf(list.indexOf(b)));
			adj[list.indexOf(b)].remove(adj[list.indexOf(b)].indexOf(list.indexOf(a)));
			Queue<Integer> q = new LinkedList();
			boolean[] vis = new boolean[26];
			q.add(list.indexOf("A")); vis[list.indexOf("A")] = true;
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int nxt: adj[cur]) {
					if (!vis[nxt]) {
						q.add(nxt);
						vis[nxt] = true;
					}
				}
			}
			if (!vis[list.indexOf("B")]) {
				System.out.println(roads.get(i));
				total++;
			}
			adj[list.indexOf(a)].add(list.indexOf(b));
			adj[list.indexOf(b)].add(list.indexOf(a));
		}
		System.out.println("There are " + total + " disconnecting roads.");
    }
}
