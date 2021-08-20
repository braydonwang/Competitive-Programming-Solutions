import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			boolean nasty = false;
			ArrayList<Integer> sum = new ArrayList<Integer>();
			ArrayList<Integer> difference = new ArrayList<Integer>();
			int num = sc.nextInt();
			for (int j = 1; j <= Math.sqrt(num); j++) {
				if (num % j == 0) {
					sum.add(j + num/j);
					difference.add(num/j - j);
				}
			}
			for (int j = 0; j < sum.size(); j++) {
				if (difference.contains(sum.get(j))) {
					nasty = true;
					break;
				}
			}
			if (nasty) {
				System.out.println(num + " is nasty");
			}
			else {
				System.out.println(num + " is not nasty");
			}
		}
    }
}
