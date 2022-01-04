package ProjectATM;

import java.util.ArrayList;

public class Account {

    private String name;

    private String uuid;

    private User holder;

    private ArrayList<Transaction> transactions;

    public Account(String name, User holder, Bank theBank){
        this.name=name;
        this.holder=holder;

        //get new account UUID
        this.uuid=theBank.getNewAccountUUIID();

        //init transaction
        this.transactions = new ArrayList<Transaction>();
    }

    public String getUUID() {
        return uuid;
    }

    public String getSummaryLine() {
        //get the account's balance
        double balance = this.getBalance();

        //format the summary line, depending on the whether the balance is negative
        if(balance>=0){
            return String.format("%s : $%.02f : %s", this.uuid, balance, this.name);
        }else{
            return String.format("%s : $(%.02f) : %s", this.uuid, balance, this.name);
        }
    }

    public double getBalance(){
        double balance=0;
        for(Transaction t: this.transactions){
            balance+=t.getAmount();
        }
        return balance;
    }

    public void printTransHistory() {
        System.out.printf("\nTransaction history for the account %s\n", this.uuid);
        for(int t=this.transactions.size()-1;t>=0;t--){
            System.out.printf(this.transactions.get(t).getSummaryLine());
        }
        System.out.println();
    }

    public void addTransaction(double amount, String memo) {
        Transaction newTransaction = new Transaction(amount, memo, this);
        this.transactions.add(newTransaction);
    }
}
