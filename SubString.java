import java.util.Scanner;
import java.util.Arrays;

public class Main {

    static int longestUniqueSubstring(String s) {
        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex, -1);

        int start = 0, maxLen = 0;

        for (int end = 0; end < s.length(); end++) {
            int idx = s.charAt(end) - 'a';

            if (lastIndex[idx] >= start) {
                start = lastIndex[idx] + 1;
            }

            lastIndex[idx] = end;
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        System.out.println(longestUniqueSubstring(s));

        sc.close();
    }
}
