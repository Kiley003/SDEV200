public class Module2(3)

/** Binary */

public static void main(String[] args {
                        String binaryString1 = "4848";
  String binaryString2 = "1213";
                        try {
                        }
  catch (NumberFormatException numberFormatException) 

   public static int bin2Dec(String binaryString) {
        int decimalValue = 0;
        if (!checkBinaryChars(binaryString)) {
            throw new BinaryFormatException(binaryString);
        }
        char[] binChars = binaryString.toCharArray();

        for (int i = binChars.length - 1, binaryIndex = 0; i >= 0; i--, binaryIndex++) {
            decimalValue += getBinaryValue(binChars[i], binaryIndex);
      }

return decimalValue;
    }

    static boolean checkBinaryChars(String binaryString) {
        char[] binStrValues = binaryString.toCharArray();
        for (char c : binStrValues) {
            if (c != '0' && c != '1') {
                return false;
            }}
        return true;}

    static int getBinaryValue(char binaryChar, int index) {
        int weight = (int) Math.pow(2, index);
        if (binaryChar == '1') {
            return weight;
        }
        return 0;
    }

}
                        
