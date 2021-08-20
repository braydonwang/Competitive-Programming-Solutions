import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> adj[] = new ArrayList[8];
		for (int i = 0; i <= 7; i++) {
			adj[i] = new ArrayList();
		}
		adj[1].add(7);
		adj[1].add(4);
		adj[2].add(1);
		adj[3].add(4);
		adj[3].add(5);
		int[] array = {1,0,0,2,1,0,1};
		while (true) {
			int x = readInt(), y = readInt();
			if (x == 0 && y == 0) {
				break;
			}
			adj[x].add(y);
			array[y-1]++;
		}
		Queue<Integer> q = new LinkedList();
		ArrayList<Integer> list = new ArrayList();
		ArrayList<Integer> rist = new ArrayList();
		boolean done = false;
		for (int i = 0; i < 7; i++) {
			if (array[i] == 0 && !done) {
				q.add(i+1);
				list.add(i+1);
				done = true;
			}
			else if (array[i] == 0 && done) {
				rist.add(i+1);
			}
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int nxt: adj[cur]) {
				array[nxt-1]--;
				if (array[nxt-1] == 0) {
					rist.add(nxt);
				}
			}
			Collections.sort(rist);
			if (!rist.isEmpty()) {
				q.add(rist.get(0));
				list.add(rist.get(0));
				rist.remove(0);
			}
		}
		if (list.size() == 7) {
			for (int i = 0; i < 7; i++) {
				System.out.print(list.get(i) + " ");
			}
		}
		else {
			System.out.println("Cannot complete these tasks. Going to bed.");
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
