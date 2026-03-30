package Printer;

public class PrintJob {
    String name;
    int pages;

    PrintJob(String name, int pages){
        this.name = name;
        this.pages =pages;
    }
    @Override
    public String toString(){
        return name + " (" +pages+ " pages ) ";
    }
}
