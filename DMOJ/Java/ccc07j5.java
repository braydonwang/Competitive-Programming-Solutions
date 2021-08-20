import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		ArrayList<Long> list = new ArrayList<Long>();
		long a = readLong(), b = readLong(), n = readLong();
		list.add((long) 0);
		list.add((long) 990);
		list.add((long) 1010);
		list.add((long) 1970);
		list.add((long) 2030);
		list.add((long) 2940);
		list.add((long) 3060);
		list.add((long) 3930);
		list.add((long) 4060);
		list.add((long) 4970);
		list.add((long) 5030);
		list.add((long) 5990);
		list.add((long) 6010);
		list.add((long) 7000);
		for (int i = 0; i < n; i++) {
			list.add(readLong());
		}
		long[] dis = new long[(int) (14+n)];
		dis[0] = 1;
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			long x = list.get(i);
			for (int j = i+1; j < list.size(); j++) {
				if (list.get(j) - x <= b) {
					if (list.get(j) - x >= a) {
						dis[j] += dis[i];
					}
				} else {
					break;
				}
			}
		}
		System.out.println(dis[list.size()-1]);
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
