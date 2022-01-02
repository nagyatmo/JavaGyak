package com.nagyadam;

public class Account {
    private int number;
    private int balance;
    private String customerName;
    private String email;
    private long phoneNumber;

    public Account(int number, int balance, String customerName, String email, long phoneNumber) {
        this.number = number;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Account() {
    }

    public int getNumber() {
        return number;
    }

    public int getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(int depositValue){
        this.balance+=depositValue;
    }
    public void withdrawFunds(int withdrawValue){
        if(balance>withdrawValue) {
            this.balance -= withdrawValue;
        }else{
            System.out.println("Insufficient funds.");
        }
    }
}
