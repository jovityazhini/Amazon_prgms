import java.util.Scanner;

public class Main {

    static int kadane(int[] arr) {
        int maxSoFar = arr[0];
        int currMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }

        return maxSoFar;
    }

    static int maxSumSubmatrix(int[][] mat, int r, int c) {
        int maxSum = Integer.MIN_VALUE;

        for (int left = 0; left < c; left++) {

            int[] temp = new int[r];

            for (int right = left; right < c; right++) {

                for (int i = 0; i < r; i++) {
                    temp[i] += mat[i][right];
                }

                int currentSum = kadane(temp);
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int r = sc.nextInt();

        System.out.print("Enter columns: ");
        int c = sc.nextInt();

        int[][] mat = new int[r][c];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println(maxSumSubmatrix(mat, r, c));

        sc.close();
    }
}
