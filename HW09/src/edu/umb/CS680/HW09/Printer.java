package edu.umb.CS680.HW09;

public class Printer {
    private static Printer Printer = null;//singleton
    private Printer(){
        
    }//Private constructor
    public  static Printer getPrint(){
        if(Printer == null)
            Printer = new Printer();
        return Printer;
        
    } //static method
    public  void print(PrintJob job){
        job.execute();
       
    }
}
