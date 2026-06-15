import java.util.Scanner;

public class StringCompression {

    public static String compress(String str) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            while (i < str.length() - 1 &&
                   str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }

            result.append(str.charAt(i));

            if (count > 1) {
                result.append(count);
            }

            count = 1;
        }

        return result.toString();
    }

    public static String decompress(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isLetter(ch)) {
                int count = 0;

                while (i + 1 < str.length() &&
                       Character.isDigit(str.charAt(i + 1))) {
                    count = count * 10 + (str.charAt(i + 1) - '0');
                    i++;
                }

                if (count == 0)
                    count = 1;

                for (int j = 0; j < count; j++) {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String compressed = compress(input);
        System.out.println("Compressed String: " + compressed);

        String decompressed = decompress(compressed);
        System.out.println("Decompressed String: " + decompressed);

        sc.close();
    }
}
