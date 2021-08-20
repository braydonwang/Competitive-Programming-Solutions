import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		int minutes = sc.nextInt(); int n = sc.nextInt();
		int[] array = new int[n]; int count = 0;
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		Arrays.sort(array);
		int x = 0;
		while (true) {
			count+= array[x];
			if (count > minutes) {
				break;
			}
			x++;
		}
		System.out.println(x);
    }
}
