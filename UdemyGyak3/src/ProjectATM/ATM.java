package ProjectATM;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        //init Bank
        Bank theBank = new Bank("Bank of Drausin");

        //add a user, which also creates a savings account
        User aUser = theBank.addUser("John","Doe","1234");

        //add a checking account for our user
        Account newAccount = new Account("Checking",aUser,theBank);
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);

        User curUser;
        while(true){
            //sty in the login prompt until successful login
            curUser=ATM.mainMenuPrompt(theBank, sc);

            // stay in the main menu until user quits
            ATM.printUserMenu(curUser, sc);
        }
    }


    public static User mainMenuPrompt(Bank theBank, Scanner sc){
        String userID;
        String pin;
        User authUser;

        //prompt the user for user ID/pin combo until a correct one is reached
        do{
            System.out.println("Welcome to the "+ theBank.getName());
            System.out.println("Enter user ID: ");
            userID = sc.nextLine();
            System.out.println("Enter pin: ");
            pin=sc.nextLine();

            //try to get the user object corresponding to the id and pin combo
            authUser = theBank.userLogin(userID, pin);
            if(authUser==null){
                System.out.println("Incorrect user ID/pin combination. " + "Please try again.");
            }
        }while(authUser==null); //continue looping until successful login
        return authUser;
    }

    public static void printUserMenu(User theUser, Scanner sc){
        //print a summary of the user's accounts
        theUser.printAccountsSummary();

        //init
        int choice;

        //user menu
        do {
            System.out.printf("Welcome %s, what would you like to do?\n", theUser.getFirstName());
            System.out.println("  1) Show account transaction history");
            System.out.println("  2) Withdrawl");
            System.out.println("  3) Deposit");
            System.out.println("  4) Transfer");
            System.out.println("  5) Quit");
            System.out.println();
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if(choice <1 || choice > 5){
                System.out.println("Invalid choice. Please choose 1-5");
            }
        }while(choice <1 || choice > 5);

        switch(choice) {
            case 1:
                ATM.showTransHistory(theUser, sc);
                break;
            case 2:
                ATM.withdrawFunds(theUser, sc);
                break;
            case 3:
                ATM.depositFunds(theUser, sc);
                break;
            case 4:
                ATM.transferFunds(theUser, sc);
                break;

        }
        //redisplay this menu unless the user wants to quit
        if(choice !=5){
            ATM.printUserMenu(theUser, sc);
        }
    }


    private static void showTransHistory(User theUser, Scanner sc) {
        int theAcct;

        //get account whose transaction history to look at
        do{
            System.out.printf("Enter the number (1-%d) of the account\n" + " whose transactions you want to see: ", theUser.numAccounts());
            theAcct=sc.nextInt()-1;
            if(theAcct<0|| theAcct>=theUser.numAccounts()){
                System.out.println("Invalid account. Please try again.");
            }
        }while(theAcct < 0 || theAcct >= theUser.numAccounts());

        //print the transaction history
        theUser.printAcctTransHistory(theAcct);
    }

    private static void transferFunds(User theUser, Scanner sc) {
        int fromAcct;
        int toAcct;
        double amount;
        double acctBal;

        //get the account to transfer from

        do{
            System.out.printf("Enter the number (1-%d) of the account\n" + "to transfer from: ", theUser.numAccounts());
            fromAcct=sc.nextInt()-1;
            if(fromAcct<0 || fromAcct>=theUser.numAccounts()){
                System.out.println("Invalid account. Please try again.");
            }
        }while(fromAcct < 0 || fromAcct >= theUser.numAccounts());

        acctBal=theUser.getAcctBalance(fromAcct);

        //get the account to transfer to
        do{
            System.out.printf("Enter the number (1-%d) of the account\n" + "to transfer to: ", theUser.numAccounts());
            toAcct=sc.nextInt()-1;
            if(toAcct<0 || toAcct>=theUser.numAccounts()){
                System.out.println("Invalid account. Please try again.");
            }
        }while(toAcct < 0 || toAcct >= theUser.numAccounts());

        //get the amount to transfer
        do{
            System.out.printf("Enter the amount to transfer (max $%.02f): $", acctBal);
            amount=sc.nextDouble();
            if(amount<0){
                System.out.println("Amount must be greater than zero.");
            }else if(amount>acctBal){
                System.out.printf("Amount must not be greater than \n"+"balance of $%.02f.\n",acctBal);
            }

        }while(amount<0||amount>acctBal);

        //finally, do the transfer
        theUser.addAcctTransaction(fromAcct, -1*amount, String.format("Transfer to account %s", theUser.getAcctUUID(toAcct)));
        theUser.addAcctTransaction(toAcct, amount, String.format("Transfer from account %s", theUser.getAcctUUID(fromAcct)));
    }


    //withdrawl from account
    private static void withdrawFunds(User theUser, Scanner sc) {
        int fromAcct;
        double amount;
        double acctBal;
        String memo;

        //get the account to transfer from

        do{
            System.out.printf("Enter the number (1-%d) of the account\n" + "to withdraw from: ", theUser.numAccounts());
            fromAcct=sc.nextInt()-1;
            if(fromAcct<0 || fromAcct>=theUser.numAccounts()){
                System.out.println("Invalid account. Please try again.");
            }
        }while(fromAcct < 0 || fromAcct >= theUser.numAccounts());

        acctBal=theUser.getAcctBalance(fromAcct);

        do{
            System.out.printf("Enter the amount to withdraw (max $%.02f): $", acctBal);
            amount=sc.nextDouble();
            if(amount<0){
                System.out.println("Amount must be greater than zero.");
            }else if(amount>acctBal){
                System.out.printf("Amount must not be greater than \n"+"balance of $%.02f.\n",acctBal);
            }

        }while(amount<0||amount>acctBal);

        //gobble up rest of previous input
        sc.nextLine();
        //get a memo
        System.out.println("Enter a memo: ");
        memo=sc.nextLine();

        theUser.addAcctTransaction(fromAcct, -1*amount, memo);
    }

    //deposit to account
    private static void depositFunds(User theUser, Scanner sc) {
        int fromAcct;
        double amount;
        double acctBal;
        String memo;

        //get the account to transfer from

        do{
            System.out.printf("Enter the number (1-%d) of the account\n" + "to deposit to: ", theUser.numAccounts());
            fromAcct=sc.nextInt()-1;
            if(fromAcct<0 || fromAcct>=theUser.numAccounts()){
                System.out.println("Invalid account. Please try again.");
            }
        }while(fromAcct < 0 || fromAcct >= theUser.numAccounts());

        acctBal=theUser.getAcctBalance(fromAcct);


            System.out.printf("Enter the amount to deposit: $", acctBal);
            amount=sc.nextDouble();
            if(amount<0){
                System.out.println("Amount must be greater than zero.");
            }



        //gobble up rest of previous input
        sc.nextLine();
        //get a memo
        System.out.println("Enter a memo: ");
        memo=sc.nextLine();

        theUser.addAcctTransaction(fromAcct, amount, memo);
    }
}
