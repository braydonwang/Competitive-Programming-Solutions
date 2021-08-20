import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		while (true) {
			String str = sc.nextLine();
			if (str.equals("0")) {
				break;
			}
			else {
				String[] array = str.split(" ");
			    Stack<String> stack = new Stack<String>();
			    for (int i = array.length - 1; i > -1; i--) {
			    	if (array[i].equals("+") || array[i].equals("-")) {
			    		String a = stack.pop();
			    		String b = stack.pop();
			    		String temp = a + b + array[i];
			    		stack.push(temp);
			    	}
			    	else {
			    		stack.push(array[i]);
			    	}
			    }
			    str = stack.peek();
			    for (int i = 0; i < str.length(); i++) {
			    	System.out.print(str.charAt(i) + " ");
			    }
			    System.out.println();
			}
		}
    }
}
