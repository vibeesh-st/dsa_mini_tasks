package Printer;

import java.util.Scanner;

public class PrinterRun {

    Scanner in =  new Scanner(System.in);
    int choice;
    PrinterQueue queue = new PrinterQueue();
public void runMenu() {
    while (true) {
        System.out.println("\nPrinter Menu:");
        System.out.println(("1. Show waiting queue"));
        System.out.println("2. Add Job");
        System.out.println("3. Remove Job");
        System.out.println("4. Execute Print");
        System.out.println("5. Current Print");
        System.out.println("6. Exit");
        System.out.println("Enter your choice");

        choice = in.nextInt();
        in.nextLine();
        switch (choice) {
            case 1:
                queue.waitingQueue();
                break;
            case 2:
                queue.addJob();
                break;
            case 3:
                queue.removeJob();
                break;
            case 4:
                try {
                    queue.executePrint();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 5:
                queue.currentPrint();
                break;
            case 6:
                System.out.println("Exiting printer program.");
                return;
            default:
                System.out.println("Invalid Choice;");
        }
    }
}
}

