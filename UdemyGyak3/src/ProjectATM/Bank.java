package ProjectATM;

import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private String name;

    private ArrayList<User> user;

    private ArrayList<Account> accounts;

    public Bank(String bankName) {
        this.name=bankName;
        this.user = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }

    public String getNewUserUUIID() {
        String uuid;
        Random rng = new Random();
        int len= 6;
        boolean nonUnique=false;


        do{
            //generate the number
            uuid="";
            for(int c=0;c<len;c++){
                uuid+=((Integer)rng.nextInt(10)).toString();
            }

            //check to make sure it's unique
            for(User u : this.user){
                if(uuid.compareTo(u.getUUID())==0){
                    nonUnique=true;
                    break;
                }
            }

        }while(nonUnique);

        return uuid;

    }


    public String getNewAccountUUIID() {
        String uuid;
        Random rng = new Random();
        int len= 10;
        boolean nonUnique=false;


        do{
            //generate the number
            uuid="";
            for(int c=0;c<len;c++){
                uuid+=((Integer)rng.nextInt(10)).toString();
            }

            //check to make sure it's unique
            for(Account u : this.accounts){
                if(uuid.compareTo(u.getUUID())==0){
                    nonUnique=true;
                    break;
                }
            }

        }while(nonUnique);

        return uuid;
    }
    public void addAccount(Account anAcct) {
        this.accounts.add(anAcct);
    }


    public User addUser(String firstName, String lastName, String pin){

        //create a new User object and add it to our list
        User newUser = new User(firstName, lastName, pin, this);
        this.user.add(newUser);

        //create a savings account
        Account newAccount = new Account("Savings",newUser, this);
        newUser.addAccount(newAccount);
        this.addAccount(newAccount);

        return newUser;
    }

    public User userLogin(String userID, String pin){
        //search throught list of users
        for(User u:this.user){

            if(u.getUUID().compareTo(userID)==0 && u.validatePin(pin)){
                return u;
            }
        }

        //if we havent found the user
        return null;
    }

    public String getName(){
        return name;
    }

}
