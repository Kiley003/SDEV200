public class Module1Programming(2) {

    public static boolean isValid(long number) {
        int size = getSize(number);
        boolean validLength = size >= 13 && size <= 16;
        boolean validPrefix = prefixMatched(number, 4) || prefixMatched(number, 5) ||
                              prefixMatched(number, 37) || prefixMatched(number, 6);
        int total = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
        return validLength && validPrefix && total % 10 == 0;}

    public static int sumOfDoubleEvenPlace(long number) {
        String numStr = Long.toString(number);
        int sum = 0;
        for (int i = numStr.length() - 2; i >= 0; i -= 2) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            sum += getDigit(digit * 2);}
        return sum;}

    public static int getDigit(int number) {
        if (number < 10) return number;
        return number / 10 + number % 10;}

    public static int sumOfOddPlace(long number) {
        String numStr = Long.toString(number);
        int sum = 0;
        for (int i = numStr.length() - 1; i >= 0; i -= 2) {
            sum += Character.getNumericValue(numStr.charAt(i));}

        return sum;}

    public static boolean prefixMatched(long number, int d) {
        int prefixSize = getSize(d);
        return getPrefix(number, prefixSize) == d;}

    public static int getSize(long d) {
        return Long.toString(d).length();}


    public static long getPrefix(long number, int k) {
        String numStr = Long.toString(number);
        if (numStr.length() < k) return number;
        return Long.parseLong(numStr.substring(0, k));}

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a credit card number: ");
        long number = input.nextLong();

        if (isValid(number)) {
            System.out.println("Credit card number is VALID.");
        } else {
            System.out.println("Credit card number is INVALID.");
        }
    }
}
