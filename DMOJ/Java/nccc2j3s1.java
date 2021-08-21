import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt(); long sum = 0; int max = 0;
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			sum += x;
			max = Math.max(max, x);
		}
		long answer = 0;
		if (sum - max >= max){
		    answer = sum/2;
		}
		else{
		    answer = sum - max;
		}
		System.out.println(answer);
    }
}
