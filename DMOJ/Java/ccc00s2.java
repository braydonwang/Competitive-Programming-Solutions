import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		ArrayList<Double> list=new ArrayList<Double>();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			list.add(sc.nextDouble());
		}
		while (true) {
			int x = sc.nextInt();
			if (x == 77) {
				break;
			}
			else if (x == 99) {
				int pos = sc.nextInt();
				int percent = sc.nextInt();
				double temp1 = list.get(pos-1) * (percent/100.0);
				double temp2 = list.get(pos-1) - temp1;
				list.set(pos-1, temp1);
				list.add(pos,temp2);
			}
			else if (x == 88) {
				int p = sc.nextInt();
				double temp = list.get(p-1) + list.get(p);
				list.remove(p-1); list.remove(p-1);
				list.add(p-1,temp);
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.print(Math.round(list.get(i)) + " ");
		}
    }
}
