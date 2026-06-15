import java.util.Scanner;

public class Main {

    static int searchMatrix(int[][] mat, int n, int m, int x) {
        int row = 0;
        int col = m - 1;

        while (row < n && col >= 0) {
            if (mat[row][col] == x)
                return 1;
            else if (mat[row][col] > x)
                col--;
            else
                row++;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        int[][] mat = new int[n][m];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter element to search: ");
        int x = sc.nextInt();

        System.out.println(searchMatrix(mat, n, m, x));

        sc.close();
    }
}
