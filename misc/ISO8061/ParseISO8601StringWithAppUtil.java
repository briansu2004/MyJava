public class ParseISO8601StringWithAppUtil {
    public static void parseString(String input) {
        System.out.println(String.format("%s -> %s", input, AppUtil.parseISO8601String(input)));

    }


    public static void main(String[] args) {
        // parseString("2023-08-31T15:30:45+00:00");

        // 20230831T153045.123Z
        parseString("20230831T153045.123Z");

        // 2023-08-31T15:30:45.123Z

        // 20230831T1530Z

        // 2023-08-31T15:30Z

        // 20230831T153045.123


        // 2023-08-31T15:30:45.123

        // 20230831

        // 2023-08-31
    }
}
