package OOP.practise.two;

public class main {
    public static void main(String[] args){
        Printer printer = new Printer(50, true);
        System.out.println("Initial page count = " + printer.getPagesPrinted());
        int pagesPrinted = printer.printPages(4);
        System.out.println("Pages printed was " + pagesPrinted +" new total print count for printer = "+printer.getPagesPrinted());
        pagesPrinted = printer.printPages(10);
        System.out.println("Pages printed was " + pagesPrinted +" new total print count for printer = "+printer.getPagesPrinted());
    }
}
