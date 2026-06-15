import java.util.Scanner;

public class Main {

    static int findStart(int[] petrol, int[] distance, int n) {
        int start = 0;
        int balance = 0;
        int deficit = 0;

        for (int i = 0; i < n; i++) {
            balance += petrol[i] - distance[i];

            if (balance < 0) {
                start = i + 1;
                deficit += balance;
                balance = 0;
            }
        }

        return (balance + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of petrol pumps: ");
        int n = sc.nextInt();

        int[] petrol = new int[n];
        int[] distance = new int[n];

        System.out.println("Enter petrol amounts:");
        for (int i = 0; i < n; i++) {
            petrol[i] = sc.nextInt();
        }

        System.out.println("Enter distances:");
        for (int i = 0; i < n; i++) {
            distance[i] = sc.nextInt();
        }

        System.out.println(findStart(petrol, distance, n));

        sc.close();
    }
}
