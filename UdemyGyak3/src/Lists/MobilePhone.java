package Lists;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Contacts> contacts = new ArrayList<Contacts>();
    private ArrayList<Calls> calls = new ArrayList<Calls>();

    public void storeContact(){
        System.out.println("Add contact's name: ");
        String name = sc.nextLine();
        System.out.println("Add contact's phone number: ");
        long phoneNumber = sc.nextLong();
        Contacts param = new Contacts(name, phoneNumber);
        contacts.add(param);
    }

    public void removeContact(){
        sc.nextLine();
        String name = sc.nextLine();
        int position=findItem(name);
        if(position>=0){
            removeContact(position);
        }else{
            System.out.println("Given name is not found in the contacts.");
        }
    }

    private void removeContact(int position){
        contacts.remove(position);
    }

    private int findItem(String param){

        for(int i=0;i<contacts.size();i++){
            if(contacts.get(i).getName().equals(param)){
               return i;
            }
        }
        return -1;
    }

    public void listContacts(){
        for(int i=0;i<contacts.size();i++){
            System.out.println((i+1) +") Contacts name: " +contacts.get(i).getName() + ", phone number: " + contacts.get(i).getPhoneNumber());
        }
    }

    public void modifyContact(){
        System.out.printf("Choose a contact you want to modify: 1-%d ",contacts.size());
        int toModify = (sc.nextInt()-1);
        System.out.println("Choosen contacts current name: "+ contacts.get(toModify).getName() +", phone number: "+ contacts.get(toModify).getPhoneNumber());

        int choice;
        do{
            System.out.println("Press 1) modify name");
            System.out.println("Press 2) modify Phone number");
            choice=sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter new name: ");
                    sc.nextLine();
                    String newName = sc.nextLine();
                    contacts.get(toModify).setName(newName);
                    System.out.println("Press 0 to quit modification.");
                    break;
                case 2:
                    System.out.println("Enter new phone number: ");
                    long newPhoneNumber = sc.nextLong();
                    contacts.get(toModify).setPhoneNumber(newPhoneNumber);
                    System.out.println("Press 0 to quit modification.");
                    break;
            }
        }while(choice ==1 || choice==2);

    }

    public void searchContact() {
    }

    public void call(){
        System.out.println("Opened contact's list: ");
        listContacts();
        System.out.println("Choose a contact you want to call: ");
        int toCall=(sc.nextInt()-1);
        Calls call = new Calls(contacts.get(toCall));
        calls.add(call);

    }
    public void callList(){
        System.out.println("Recent calls:");
        for(int i=0;i<calls.size();i++){
            System.out.println("Called " + calls.get(i).getCalledContact().getName() +" : " + calls.get(i).getCalledContact().getPhoneNumber() +" "+  calls.get(i).getTimeStamp());
        }
    }
}
