package Printer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrinterQueue {
    Scanner in = new Scanner(System.in);

    public PrinterQueue(){

    };

    Queue<PrintJob> queue = new LinkedList<>();

    public void executePrint() throws InterruptedException {
        PrintJob job =  queue.poll();
        if(job!=null){
            System.out.println("Printing: "+ job);
            Thread.sleep(job.pages * 500);
            System.out.println("Finished printing: "+ job.name);
        }
        else {
            System.out.println("No jobs left");
        }
    }


    public void currentPrint(){
        PrintJob job = queue.peek();
        if(job != null) {
            System.out.println("Current print :" + job);
        }
        else{
            System.out.println("No job in the queue");
        }
    }

    public void addJob() {
        System.out.println("Enter job name");
        String name = in.nextLine();

        System.out.println("Enter number of pages");
        int pages = in.nextInt();
        in.nextLine();

        if (name != null && !name.isEmpty() && pages > 0) {
            queue.offer(new PrintJob(name, pages));
            System.out.println("Added job: " + name);
        } else {
            System.out.println("Invalid job details");
        }
    }
     public void removeJob () {

            PrintJob job = queue.poll();
            if (job != null) {
                System.out.println("Removed job: " + job);
            } else {
                System.out.println("Queue is Empty");
            }
    }

        public void waitingQueue () {
         if(!queue.isEmpty()){
             System.out.println("All the jobs left: "+ queue);
         }
         else {
             System.out.println("No jobs left");
         }
        }


}

