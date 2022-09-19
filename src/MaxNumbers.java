import java.util.Scanner;

public class MaxNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= 3; i++) {
            System.out.println("Enter number ");
            int input = scanner.nextInt();
            max = input > max ? input : max;
        }
        System.out.println("Max = " + max);
        scanner.close();
    }
    
}

