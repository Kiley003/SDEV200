import java.until*;
import java.io*;

public class Module4Exercise(2) {
    static boolean inString;
    static boolean inComment;

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("The number of keywords in" + Filename +
 "is" countKeyword(file));
            return;
        }

        String filename = args[0];
        File file = new File(filename);

        if (file.exists()) {
            System.out.println("The number of keywords in " + Filename
                    + " is " + countKeywords(file));
        } else {
            System.out.println("File " + filename + " does not exist");
        }
    }

    public static int countKeywords(File file) throws Exception {
        String[] keywordString = {"abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum",
                "extends", "for", "final", "finally", "float", "goto",
                "if", "implements", "import", "instanceof", "int",
                "interface", "long", "native", "new", "package", "private",
                "protected", "public", "return", "short", "static",
                "strictfp", "super", "switch", "synchronized", "this",
                "throw", "throws", "transient", "try", "void", "volatile",
                "while", "true", "false", "null"};
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        int count = 0;
        Scanner input = new Scanner(file);

   while (input.hasNext()) {
            String word = input.next();
            } if (word.contains("/*")) {
                System.out.println("Inside multiline comment.");
                inComment = true;
                while (inComment) {
                    word = input.next(); 
                    if (word.contains("*/")) { 
                        inComment = false;
                        System.out.println("End of comment");
                        break;
                    }
                }
      else {
                if (keywordSet.contains(word)) {
                    System.out.println("Keyword detected: " + word);
                    count++;
                }
            }
        }
        return count;
    }
}
