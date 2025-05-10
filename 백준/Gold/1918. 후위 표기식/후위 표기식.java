import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(char c : s.toCharArray()) {
			if(Character.isLetter(c))
				sb.append(c);
			else if(c=='(')
				stack.push(c);
			else if(c==')') {
				while(!stack.isEmpty() && stack.peek()!='(') sb.append(stack.pop());
				stack.pop();
			}else {
				while(!stack.isEmpty() && precedence(stack.peek())>=precedence(c)) sb.append(stack.pop());
				stack.push(c);
			}
		}


		System.out.print(sb.toString());

		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}

		br.close();
	}
	static private int precedence(char op) {
		if(op=='(') return 0;
		if(op=='+' || op=='-') return 1;
		if(op=='*' || op=='/') return 2;
		return -1;
	}
}
