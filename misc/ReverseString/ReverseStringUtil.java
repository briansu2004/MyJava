
class ReverseStringUtil {
    // StringBuilder built-in reverse
    static String reverseString1(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // Swap chars
    static String reverseString2(String str) {
        if (str == null)
            return null;

        char[] reverseCharArray = str.toCharArray();
        for (int i = 0; i < str.length() / 2; i++) {
            char c = str.charAt(str.length() - 1 - i);
            reverseCharArray[str.length() - 1 - i] = reverseCharArray[i];
            reverseCharArray[i] = c;
        }
        return new String(reverseCharArray);
    }

    // Concatenate chars
    static String reverseString3(String str) {
        String reversedString = "";
        for (int i = str.length(); i > 0; i--) {
            reversedString += str.charAt(i - 1);
        }
        return reversedString;
    }

    static void tryIt(String str) {
        System.out.println(">>> Using the 1st method: StringBuilder built-in reverse");
        System.out.printf("The reverse string of %s is %s <<<\n", str, reverseString1(str));

        System.out.println(">>> Using the 2nd method: Swap chars");
        System.out.printf("The reverse string of %s is %s <<<\n", str, reverseString2(str));

        System.out.println(">>> Using the 3rd method: Concatenate chars");
        System.out.printf("The reverse string of %s is %s <<<\n", str, reverseString3(str));
    }

    public static void main(String[] args) {
        tryIt("Hello");

        tryIt("Brian");

        tryIt("Offer");
    }
}