package week1;

import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static Locale getLocaleFromChoice(int choice) {
        return switch (choice) {
            case 2 -> new Locale("fi", "FI");
            case 3 -> new Locale("sv", "SE");
            case 4 -> new Locale("ja", "JP");
            default -> new Locale("en", "US");
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select language:");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Swedish");
        System.out.println("4. Japanese");
        System.out.print("Enter a number for language: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        Locale locale = switch (choice) {
            case 2 -> new Locale("fi", "FI");
            case 3 -> new Locale("sv", "SE");
            case 4 -> new Locale("ja", "JP");
            default -> new Locale("en", "US");
        };

        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", locale);

        System.out.println(rb.getString("welcome_text"));
        System.out.print(rb.getString("enter_item_count") + " ");
        int numItems = scanner.nextInt();

        BigDecimal total = BigDecimal.ZERO;

        for (int i = 1; i <= numItems; i++) {
            System.out.print(rb.getString("enter_price") + " " + i + ": ");
            BigDecimal price = scanner.nextBigDecimal();

            System.out.print(rb.getString("enter_quantity") + " " + i + ": ");
            int quantity = scanner.nextInt();

            BigDecimal itemTotal = price.multiply(BigDecimal.valueOf(quantity));
            total = total.add(itemTotal);
        }

        System.out.println(rb.getString("total_cost") + " " +
                total.setScale(2, RoundingMode.HALF_UP) + " €");
    }
}
