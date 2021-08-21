import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		ArrayList<String> all = new ArrayList<String>();
		String str = "";
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			all.add(sc.next());
		}
		for (int i = 0; i < n; i++) {
			for (int a = 0; a < all.size(); a++) {
				list.add(all.get(a));
			}
			for (int j = 0; j < m; j++) {
				int max = 0;
				if (list.size() == 1) {
					break;
				}
				for (int k = 0; k < list.size(); k++) {
					if (list.get(k).charAt(j) > max) {
						max = list.get(k).charAt(j);
					}
				}
				for (int k = 0; k < list.size(); k++) {
					if (list.get(k).charAt(j) != max){
						list.remove(k);
						k--;
					}
				}
			}
			str += list.get(0);
			all.remove(all.indexOf(list.get(0)));
			list = new ArrayList<String>();
		}
		System.out.println(str);
    }
}
