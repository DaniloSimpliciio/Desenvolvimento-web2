import java.util.Scanner;

public class App2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int number1, number2, sum;

        System.out.print("digite um numero: ");
        number1 = scanner.nextInt();
        System.out.print("digite outro numero: ");
        number2 = scanner.nextInt();

        sum = number1 + number2;

        System.out.println("Soma= " + sum);
        scanner.close();
    }
}
