import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int[] freq = new int[1000]; int lo = 0; int hi = 0; int max = 0;
		int n = sc.nextInt();
		for (int i = 0 ; i < n; i++) {
			int x = sc.nextInt();
			freq[x-1]++;
		}
		for (int i = 0; i < 1000; i++) {
			if (freq[i] > max) {
				max = freq[i];
				lo = i+1;
				hi = i+1;
			}
			else if (freq[i] == max) {
				hi = i+1;
			}
		}
		if (hi == lo) {
			int smax = 0; int slo = 0; int shi = 0;
			for (int i = 0; i < 1000; i++) {
				if (freq[i] > smax && freq[i] < max) {
					smax = freq[i];
					slo = i+1;
					shi = i+1;
				}
				else if (freq[i] == smax) {
					shi = i+1;
				}
			}
			System.out.println(Math.max(Math.abs(slo-lo), Math.abs(shi-lo)));
		}
		else {
			System.out.println(hi-lo);
		}
    }
}
