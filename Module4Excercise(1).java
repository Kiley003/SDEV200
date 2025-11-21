import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;

public class Module4Excercise(1) {

    private static final String SYMBOLS = "(){}[]";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Exercise20_11 correct.txt");
            System.exit(1);
        }
        try {

            Stack<Character> symbols = populateStack(args[0]);
            boolean correctPairs = checkSymbols(symbols);
            String result = "";
            if (correctPairs) {
                result += "correct number of pairs";
            } else {
                result += "incorrect number of pairs";
            }
          File file = new File(args[0]);
		if (!file.exists()) {
			System.out.println("The file " + args[0] + " does not exist");
			System.exit(1);
		}
    Stack<Character> symbols = new Stack<>();

		try ( 
				Scanner input = new Scanner(file);
		) {
			while (input.hasNext()) {
				String line = input.nextLine();
				for (int i = 0; i < line.length(); i++) {
					char ch = line.charAt(i);
					if (ch == '(' || ch == '{' || ch == '[') {
						symbols.push(ch);
					} 
					else if (ch == ')' || ch == '}' || ch == ']') {
						processSymbols(symbols, ch);
					}
				}
			}
		
		System.out.println("The java source-code" +
			(symbols.isEmpty() ? "has" : "does not have") + " correct pairs");	
	}
	private static void processSymbols(
			Stack<Character> stack, Character ch) {
		if ((stack.peek() == '(' && ch == ')') ||
			 (stack.peek() == '[' && ch == ']') ||
			 (stack.peek() == '{' && ch == '}')) {
			stack.pop();	
		}
		else if ((stack.peek() != '(' && ch == ')') ||
			 (stack.peek() != '[' && ch == ']') ||
			 (stack.peek() != '{' && ch == '}')) {
			System.out.println("The Java source-code does not have" 
				+ " correct pairs.");
			System.exit(1);
		}
	}
}
