package ProjectATM;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.security.MessageDigest;

public class User {

    private String firstName;

    private String lastName;

    private String uuid;

    //MD5 Hash algorithm
    private byte pinHash[];

    private ArrayList<Account> accounts;

    /**
     * @param firstName
     * @param lastName
     * @param pin
     * @param theBank
     */
    public User(String firstName, String lastName, String pin, Bank theBank) {
        this.firstName = firstName;
        this.lastName = lastName;


        // store the pin's MD5 hash, rather than the original value for security reasons;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }

        // get a new, unique universal ID for the user
        this.uuid=theBank.getNewUserUUIID();

        //create empty list of accounts
        this.accounts = new ArrayList<Account>();

        //print log message
        System.out.println("New user "+ lastName + ", " + firstName +" with ID: "+ this.uuid+ " created.");
    }

    public void addAccount(Account anAcct) {
        this.accounts.add(anAcct);
    }

    public String getUUID() {
        return uuid;
    }

    public boolean validatePin(String aPin) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(aPin.getBytes()),this.pinHash);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }
        return false;
    }
    public String getFirstName(){
        return firstName;
    }

    public void printAccountsSummary() {
        System.out.printf("\n\n%s's accounts summary", this.firstName);
        for(int a=0;a<this.accounts.size();a++){
            System.out.printf("%d) %s\n",a+1 , this.accounts.get(a).getSummaryLine());
        }
        System.out.println();
    }

    public int numAccounts() {
        return this.accounts.size();
    }

    public void printAcctTransHistory(int acctIdx) {
        this.accounts.get(acctIdx).printTransHistory();
    }

    public double getAcctBalance(int acctIdx) {
        return this.accounts.get(acctIdx).getBalance();
    }

    public String getAcctUUID(int acctIdx){
        return this.accounts.get(acctIdx).getUUID();
    }

    public void addAcctTransaction(int acctIdx, double amount, String memo) {
        this.accounts.get(acctIdx).addTransaction(amount, memo);
    }
}
