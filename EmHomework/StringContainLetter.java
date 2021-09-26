import java.util.regex.Pattern;

public class StringContainLetter {
    public static void main(String[] args) {
        String s = "aUc";
        // testString(s);

        // s = "89";
        // testString(s);

        try {
            testString(s);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //
        }

    }

    public static boolean containsLetter(String str) {
        // return Pattern.matches("[a-zA-Z]", str);

        if (str.contains("a")) {
            return true;
        }
        return false;

    }

    public static void testString(String str) {
        System.out.println(str + " contains letter: " + containsLetter(str));
    }
}
