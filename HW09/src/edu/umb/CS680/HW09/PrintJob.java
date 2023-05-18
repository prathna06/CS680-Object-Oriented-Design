package edu.umb.CS680.HW09;

public class PrintJob implements PrintCommand {
    public PrintJob() {
    }
    public void execute(){
        System.out.println("printer Job done dv");
    }

    public void printer(PrintJob job){
        var printer = Printer.getPrint();
        printer.print(job);
     
    }

}
