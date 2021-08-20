import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			String name = sc.next();
			int num = sc.nextInt();
			names.add(name); numbers.add(num);
		}
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>(); 
		int x = sc.nextInt();
		int max = 0;
		for (int i = 0; i < x; i++) {
			int a = sc.nextInt();
			map.put(a, map.getOrDefault(a, 0)+1);
			max = Math.max(map.get(a), max);
		}
		for (int nxt: map.keySet()) {
			if (map.get(nxt) == max) {
				System.out.println(names.get(numbers.indexOf(nxt)));
				break;
			}
		}
    }
}
