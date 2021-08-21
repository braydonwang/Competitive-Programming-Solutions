import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		ArrayList<Integer> energy=new ArrayList<Integer>();
		ArrayList<Integer> log=new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			energy.add(sc.nextInt());
		}
		for (int i = 0; i < n; i++) {
			log.add(sc.nextInt());
		}
		Collections.sort(energy);
		Collections.sort(log,Collections.reverseOrder());
		long total = 0;
		for (int i = 0; i < n; i++) {
			total+= energy.get(i)*log.get(i);
		}
		System.out.println(total);
    }
}
