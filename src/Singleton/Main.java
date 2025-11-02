package Singleton;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PagIbigQueueSystem queueManager = PagIbigQueueSystem.getInstance();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nPag-ibig Centralized Queuing System");
            System.out.println("1. Generate New Queue Number");
            System.out.println("2. Check Current Queue Status");
            System.out.println("3. Reset Queue to New Number");
            System.out.println("4. View All Desk Serving Numbers");
            System.out.println("5. Exit the System");
            System.out.print("Select option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(queueManager.getNextQueueNumberFormatted());
                    break;
                case 2:
                    System.out.println("Current queue number: " + queueManager.getCurrentQueueNumberFormatted());
                    break;
                case 3:
                    System.out.print("Enter new queue number: ");
                    int newNum = scanner.nextInt();
                    System.out.println(queueManager.resetQueueNumberFormatted(newNum));
                    break;
                case 4:
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Desk " + (i + 1) + ": Now Serving " + queueManager.getDeskServingNumberFormatted(i));
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
